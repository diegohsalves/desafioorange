package com.orangetalents.desafio.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OutVeiculoDTO {

    private String marca;
    private String modelo;
    private String ano;
    private String valor;
    private String diaRodizio;
    private boolean rodizioAtivo;
}
