package com.orangetalents.desafio.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ModelosDTO {

    private List<ModeloDTO> modelos;
    private List<AnoModeloDTO> anos;
}
