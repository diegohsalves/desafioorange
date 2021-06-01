package com.orangetalents.desafio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InUsuarioDTO {

    @NotBlank
    @Size(min = 11, max = 11)
    private String cpf;

    @NotBlank
    private String nome;

    @NotBlank
    private String email;

    @NotNull
    private LocalDate nascimento;
}
