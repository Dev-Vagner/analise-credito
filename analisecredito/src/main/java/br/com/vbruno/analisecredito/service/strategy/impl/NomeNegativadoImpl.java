package br.com.vbruno.analisecredito.service.strategy.impl;

import br.com.vbruno.analisecredito.constante.MensagemConstante;
import br.com.vbruno.analisecredito.domain.Proposta;
import br.com.vbruno.analisecredito.exception.StrategyException;
import br.com.vbruno.analisecredito.service.strategy.CalculoPonto;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

@Order(1)
@Component
public class NomeNegativadoImpl implements CalculoPonto {

    @Override
    public int calcular(Proposta proposta) {
        if(nomeNegativado()) throw new StrategyException(String.format(MensagemConstante.CLIENTE_NEGATIVADO, proposta.getUsuario().getNome()));

        return 100;
    }

    private boolean nomeNegativado() {
        return new Random().nextBoolean();
    }
}
