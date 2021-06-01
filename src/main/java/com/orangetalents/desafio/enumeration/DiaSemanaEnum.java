package com.orangetalents.desafio.enumeration;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum DiaSemanaEnum {

    SEGUNDA_FEIRA(1, "segunda-feira"),
    TERCA_FEIRA(2, "terça-feira"),
    QUARTA_FEIRA(3, "quarta-feira"),
    QUINTA_FEIRA(4, "quinta-feira"),
    SEXTA_FEIRA(5, "sexta-feira"),
    DIA_INVALIDO(0, "Dia inválido");

    private final int indexDiaSemana;
    private final String diaSemana;

    DiaSemanaEnum(int indexDiaSemana, String diaSemana) {
        this.indexDiaSemana = indexDiaSemana;
        this.diaSemana = diaSemana;
    }

    public static DiaSemanaEnum getByIndexDiaSemana(int indexDiaSemana) {
        return Arrays.stream(DiaSemanaEnum.values())
                .filter(enumeration -> indexDiaSemana == enumeration.getIndexDiaSemana())
                .findFirst()
                .orElse(DiaSemanaEnum.DIA_INVALIDO);
    }
}
