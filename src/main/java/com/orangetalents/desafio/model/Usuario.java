package com.orangetalents.desafio.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "usuario")
public class Usuario {

    @Id
    private String cpf;

    private String nome;

    private String email;

    private LocalDate nascimento;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Veiculo> veiculos;
}
