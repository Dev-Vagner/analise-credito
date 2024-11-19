package br.com.vbruno.analisecredito.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfigBindings {

    @Autowired
    private RabbitMQConfigQueues configQueues;

    @Autowired
    private RabbitMQConfigExchanges configExchanges;

    @Bean
    public Binding criarBindingPropostaPendenteMsAnaliseCredito() {
        return BindingBuilder.bind(configQueues.criarFilaPropostaPendenteMsAnaliseCredito())
                .to(configExchanges.criarFanoutExchangePropostaPendente());
    }

    @Bean
    public Binding criarBindingPropostaPendenteMsAnaliseCreditoDlxDlq() {
        return BindingBuilder.bind(configQueues.criarFilaPropostaPendenteMsAnaliseCreditoDlq())
                .to(configExchanges.criarFanoutExchangePropostaPendenteMsAnaliseCreditoDlx());
    }
}
