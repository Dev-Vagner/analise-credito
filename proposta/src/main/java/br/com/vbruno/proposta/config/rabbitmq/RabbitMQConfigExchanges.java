package br.com.vbruno.proposta.config.rabbitmq;

import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfigExchanges {

    @Value("${rabbitmq.proposta-concluida.exchange}")
    private String exchangePropostaConcluida;

    @Value("${rabbitmq.proposta-concluida.ms-proposta.dlx}")
    private String dlxPropostaConcluidaMsProposta;

    @Bean
    public FanoutExchange criarFanoutExchangePropostaConcluida() {
        return ExchangeBuilder.fanoutExchange(exchangePropostaConcluida).build();
    }

    @Bean
    public FanoutExchange criarFanoutExchangePropostaConcluidaMsPropostaDlx() {
        return ExchangeBuilder.fanoutExchange(dlxPropostaConcluidaMsProposta).build();
    }
}
