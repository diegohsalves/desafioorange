package com.orangetalents.desafio.configuration;

import com.orangetalents.desafio.dto.InUsuarioDTO;
import com.orangetalents.desafio.dto.InVeiculoDTO;
import com.orangetalents.desafio.dto.OutUsuarioDTO;
import com.orangetalents.desafio.dto.OutVeiculoDTO;
import com.orangetalents.desafio.model.Usuario;
import com.orangetalents.desafio.model.Veiculo;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper getModelMapper() {
        var modelMapper = new ModelMapper();

        modelMapper.createTypeMap(Usuario.class, OutUsuarioDTO.class);
        modelMapper.createTypeMap(InUsuarioDTO.class, Usuario.class);

        modelMapper.createTypeMap(Veiculo.class, OutVeiculoDTO.class);
        modelMapper.createTypeMap(InVeiculoDTO.class, Veiculo.class);

        return modelMapper;
    }
}
