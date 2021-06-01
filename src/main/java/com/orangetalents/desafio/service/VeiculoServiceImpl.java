package com.orangetalents.desafio.service;

import com.orangetalents.desafio.dto.InVeiculoDTO;
import com.orangetalents.desafio.exception.CpfNaoCadastradoException;
import com.orangetalents.desafio.exception.ResourceNotFoundException;
import com.orangetalents.desafio.model.Usuario;
import com.orangetalents.desafio.model.Veiculo;
import com.orangetalents.desafio.repository.VeiculoRepository;
import com.orangetalents.desafio.service.client.FipeClient;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class VeiculoServiceImpl implements VeiculoService {

    private final UsuarioService usuarioService;
    private final VeiculoRepository veiculoRepository;
    private final ModelMapper modelMapper;
    private final FipeClient fipeClient;

    public VeiculoServiceImpl(UsuarioService usuarioService, VeiculoRepository veiculoRepository, ModelMapper modelMapper, FipeClient fipeClient) {
        this.usuarioService = usuarioService;
        this.veiculoRepository = veiculoRepository;
        this.modelMapper = modelMapper;
        this.fipeClient = fipeClient;
    }

    @Override
    public Veiculo create(InVeiculoDTO veiculoDto) {

        try {
            var usuario = modelMapper.map(usuarioService.findById(veiculoDto.getCpfProprietario()), Usuario.class);
            var veiculo = modelMapper.map(veiculoDto, Veiculo.class);

            veiculo.setValor(buscaValorVeiculo(veiculo));
            veiculo.setUsuario(usuario);
            return veiculoRepository.save(veiculo);

        } catch (ResourceNotFoundException e) {
            throw new CpfNaoCadastradoException(e.getMessage());
        }
    }

    private String buscaValorVeiculo(Veiculo veiculo) {

        var marcas = fipeClient.findMarcas();

        var marcaDto = marcas.stream()
                .filter(marcasDTO -> marcasDTO.getNome().equals(veiculo.getMarca()))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Marca não encontrada na Fipe"));

        var modelos = fipeClient.findModelos(marcaDto.getCodigo());

        var modeloDto = modelos.getModelos().stream()
                .filter(modeloDTO -> modeloDTO.getNome().equals(veiculo.getModelo()))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Modelo não encontrado na Fipe"));

        var anosModelos = fipeClient.findAnosModelo(marcaDto.getCodigo(), modeloDto.getCodigo());

        var anoModeloDto = anosModelos.stream()
                .filter(anoModeloDTO -> anoModeloDTO.getNome().equals(veiculo.getAno()))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Ano não encontrado na Fipe"));

        var fipe = fipeClient.findFipe(marcaDto.getCodigo(), modeloDto.getCodigo(), anoModeloDto.getCodigo());

        if (fipe == null) {
            throw new ResourceNotFoundException("Informação de Fipe não encontradas para o veículo");
        }

        return fipe.getValor();
    }
}
