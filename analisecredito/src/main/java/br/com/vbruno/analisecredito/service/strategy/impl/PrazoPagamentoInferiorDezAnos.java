package br.com.vbruno.analisecredito.service.strategy.impl;

import br.com.vbruno.analisecredito.domain.Proposta;
import br.com.vbruno.analisecredito.service.strategy.CalculoPonto;

public class PrazoPagamentoInferiorDezAnos implements CalculoPonto {

    @Override
    public int calcular(Proposta proposta) {
        return proposta.getPrazoPagamento() < 120 ? 80 : 0;
    }
}
