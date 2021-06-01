package com.orangetalents.desafio.service;

import com.orangetalents.desafio.dto.InVeiculoDTO;
import com.orangetalents.desafio.model.Veiculo;

public interface VeiculoService {
    Veiculo create(InVeiculoDTO veiculoDTO);
}
