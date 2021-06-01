package com.orangetalents.desafio.service;

import com.orangetalents.desafio.dto.InUsuarioDTO;
import com.orangetalents.desafio.dto.OutUsuarioDTO;
import com.orangetalents.desafio.exception.CpfCadastradoException;
import com.orangetalents.desafio.exception.EmailCadastradoException;
import com.orangetalents.desafio.exception.ResourceNotFoundException;
import com.orangetalents.desafio.model.Usuario;
import com.orangetalents.desafio.repository.UsuarioRepository;
import com.orangetalents.desafio.util.RodizioVeiculoUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, ModelMapper modelMapper) {
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Usuario create(InUsuarioDTO usuarioDTO) {

        if (usuarioRepository.findById(usuarioDTO.getCpf()).isPresent()) {
            throw new CpfCadastradoException(String.format("CPF %s cadastrado para outro Usuário", usuarioDTO.getCpf()));
        }

        if (this.findByEmail(usuarioDTO.getEmail()).isPresent()) {
            throw new EmailCadastradoException(String.format("Email %s cadastrado para outro Usuário", usuarioDTO.getEmail()));
        }

        return usuarioRepository.save(modelMapper.map(usuarioDTO, Usuario.class));
    }

    public OutUsuarioDTO findById(String cpf) {

        var outUsuarioDto = modelMapper.map(
                usuarioRepository.findById(cpf).orElseThrow(() -> new ResourceNotFoundException(String.format("Usuário não encontrado com CPF %s", cpf))), OutUsuarioDTO.class);

        var indexDayOfWeek = LocalDate.now().getDayOfWeek().getValue();

        outUsuarioDto.getVeiculos().forEach(veiculoDTO -> {

            var anoVeiculo = Integer.parseInt(veiculoDTO.getAno().substring(0, 4));
            var diaSemanaEnum = RodizioVeiculoUtil.diaSemanaRodizioByAnoVeiculo(anoVeiculo);
            veiculoDTO.setDiaRodizio(diaSemanaEnum.getDiaSemana());
            veiculoDTO.setRodizioAtivo(indexDayOfWeek == diaSemanaEnum.getIndexDiaSemana());
        });

        return outUsuarioDto;
    }

    private Optional<Usuario> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
}
