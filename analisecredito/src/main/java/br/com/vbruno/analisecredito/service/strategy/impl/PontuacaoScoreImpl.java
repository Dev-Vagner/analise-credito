package br.com.vbruno.analisecredito.service.strategy.impl;

import br.com.vbruno.analisecredito.domain.Proposta;
import br.com.vbruno.analisecredito.service.strategy.CalculoPonto;

import java.util.Random;

public class PontuacaoScoreImpl implements CalculoPonto {

    @Override
    public int calcular(Proposta proposta) {
        int score = score();

        if(score <= 200) throw new RuntimeException("Score abaixo");

        if(score <= 400) return 150;

        if(score <= 600) return 180;

        return 220;
    }

    private int score() {
        return new Random().nextInt(0, 1000);
    }
}
