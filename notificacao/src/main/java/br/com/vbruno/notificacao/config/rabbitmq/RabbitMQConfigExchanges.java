package br.com.vbruno.notificacao.config.rabbitmq;

import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfigExchanges {

    @Value("${rabbitmq.proposta-pendente.exchange}")
    private String exchangePropostaPendente;

    @Value("${rabbitmq.proposta-concluida.exchange}")
    private String exchangePropostaConcluida;

    @Value("${rabbitmq.proposta-pendente.ms-notificacao.dlx}")
    private String dlxPropostaPendenteMsNotificacao;

    @Value("${rabbitmq.proposta-concluida.ms-notificacao.dlx}")
    private String dlxPropostaConcluidaMsNotificacao;

    @Bean
    public FanoutExchange criarFanoutExchangePropostaPendente() {
        return ExchangeBuilder.fanoutExchange(exchangePropostaPendente).build();
    }

    @Bean
    public FanoutExchange criarFanoutExchangePropostaConcluida() {
        return ExchangeBuilder.fanoutExchange(exchangePropostaConcluida).build();
    }

    @Bean
    public FanoutExchange criarFanoutExchangePropostaPendenteMsNotificacaoDlx() {
        return ExchangeBuilder.fanoutExchange(dlxPropostaPendenteMsNotificacao).build();
    }

    @Bean
    public FanoutExchange criarFanoutExchangePropostaConcluidaMsNotificacaoDlx() {
        return ExchangeBuilder.fanoutExchange(dlxPropostaConcluidaMsNotificacao).build();
    }
}
