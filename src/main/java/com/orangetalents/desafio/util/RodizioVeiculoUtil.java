package com.orangetalents.desafio.util;

import com.orangetalents.desafio.enumeration.DiaSemanaEnum;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RodizioVeiculoUtil {

    public DiaSemanaEnum diaSemanaRodizioByAnoVeiculo(int ano) {

        DiaSemanaEnum diaSemanaEnum = DiaSemanaEnum.DIA_INVALIDO;
        var digitoFinalAno = ano % 10;

        switch (digitoFinalAno) {
            case 0:
            case 1: {
                diaSemanaEnum = DiaSemanaEnum.SEGUNDA_FEIRA;
                break;
            }
            case 2:
            case 3: {
                diaSemanaEnum = DiaSemanaEnum.TERCA_FEIRA;
                break;
            }
            case 4:
            case 5: {
                diaSemanaEnum = DiaSemanaEnum.QUARTA_FEIRA;
                break;
            }
            case 6:
            case 7: {
                diaSemanaEnum = DiaSemanaEnum.QUINTA_FEIRA;
                break;
            }
            case 8:
            case 9: {
                diaSemanaEnum = DiaSemanaEnum.SEXTA_FEIRA;
                break;
            }
            default: {
                break;
            }
        }
        return diaSemanaEnum;
    }
}
