package com.orangetalents.desafio.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String marca;

    private String modelo;

    private String valor;

    private String ano;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cpf_proprietario", referencedColumnName = "cpf")
    private Usuario usuario;
}
