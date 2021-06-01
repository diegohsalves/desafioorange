package com.orangetalents.desafio.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
public class FipeDTO {

    private String valor;
    private String marca;
    private String modelo;
    private int anoModelo;
    private String combustivel;
    private String codigoFipe;
    private String mesReferencia;
    private int tipoVeiculo;
    private String siglaCombustivel;
}
