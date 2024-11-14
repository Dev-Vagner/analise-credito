package br.com.vbruno.analisecredito.service.strategy.impl;

import br.com.vbruno.analisecredito.domain.Proposta;
import br.com.vbruno.analisecredito.service.strategy.CalculoPonto;

import java.util.Random;

public class OutrosEmprestimosEmAndamento implements CalculoPonto {

    @Override
    public int calcular(Proposta proposta) {
        return outrosEmprestimosEmAndamento() ? 0 : 80;
    }

    private boolean outrosEmprestimosEmAndamento() {
        return new Random().nextBoolean();
    }
}
