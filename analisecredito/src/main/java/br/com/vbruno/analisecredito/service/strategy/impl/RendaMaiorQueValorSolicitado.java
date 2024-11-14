package br.com.vbruno.analisecredito.service.strategy.impl;

import br.com.vbruno.analisecredito.domain.Proposta;
import br.com.vbruno.analisecredito.service.strategy.CalculoPonto;

public class RendaMaiorQueValorSolicitado implements CalculoPonto {

    @Override
    public int calcular(Proposta proposta) {
        return rendaMaiorValorSolicitado(proposta) ? 100 : 0;
    }

    private boolean rendaMaiorValorSolicitado(Proposta proposta) {
        return proposta.getUsuario().getRenda().compareTo(proposta.getValorSolicitado()) > 0;
    }
}
