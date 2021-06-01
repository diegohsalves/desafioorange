package com.orangetalents.desafio.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class InVeiculoDTO {

    @NotBlank
    private String marca;

    @NotBlank
    private String modelo;

    @NotNull
    private String ano;

    @NotBlank
    private String cpfProprietario;
}
