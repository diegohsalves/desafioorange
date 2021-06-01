package com.orangetalents.desafio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OutUsuarioDTO {

    private String cpf;
    private String nome;
    private String email;
    private LocalDate nascimento;
    private List<OutVeiculoDTO> veiculos;
}
