package br.com.vbruno.analisecredito.config.rabbitmq;

import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfigExchanges {


    @Value("${rabbitmq.proposta-pendente.exchange}")
    private String exchangePropostaPendente;

    @Value("${rabbitmq.proposta-pendente.ms-analise-credito.dlx}")
    private String dlxPropostaPendenteMsAnaliseCredito;

    @Bean
    public FanoutExchange criarFanoutExchangePropostaPendente() {
        return ExchangeBuilder.fanoutExchange(exchangePropostaPendente).build();
    }

    @Bean
    public FanoutExchange criarFanoutExchangePropostaPendenteMsAnaliseCreditoDlx() {
        return ExchangeBuilder.fanoutExchange(dlxPropostaPendenteMsAnaliseCredito).build();
    }
}
