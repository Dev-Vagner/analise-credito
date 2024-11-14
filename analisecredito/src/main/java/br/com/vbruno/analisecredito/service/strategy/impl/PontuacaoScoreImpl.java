package br.com.vbruno.analisecredito.service.strategy.impl;

import br.com.vbruno.analisecredito.constante.MensagemConstante;
import br.com.vbruno.analisecredito.domain.Proposta;
import br.com.vbruno.analisecredito.exception.StrategyException;
import br.com.vbruno.analisecredito.service.strategy.CalculoPonto;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

@Order(2)
@Component
public class PontuacaoScoreImpl implements CalculoPonto {

    @Override
    public int calcular(Proposta proposta) {
        int score = score();

        if(score < 200) throw new StrategyException(String.format(MensagemConstante.PONTUACAO_SERASA_BAIXA, proposta.getUsuario().getNome()));

        if(score <= 400) return 150;

        if(score <= 600) return 180;

        return 220;
    }

    private int score() {
        return new Random().nextInt(0, 1000);
    }
}
