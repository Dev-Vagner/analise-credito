package br.com.vbruno.analisecredito.service.strategy;

import br.com.vbruno.analisecredito.domain.Proposta;

public interface CalculoPonto {

    int calcular(Proposta proposta);
}
