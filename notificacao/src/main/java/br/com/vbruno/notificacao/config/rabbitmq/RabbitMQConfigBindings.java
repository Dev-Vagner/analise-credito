package br.com.vbruno.notificacao.config.rabbitmq;

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
    public Binding criarBindingPropostaPendenteMsNotificacao() {
        return BindingBuilder.bind(configQueues.criarFilaPropostaPendenteMsNotificacao())
                .to(configExchanges.criarFanoutExchangePropostaPendente());
    }

    @Bean
    public Binding criarBindingPropostaConcluidaMsNotificacao() {
        return BindingBuilder.bind(configQueues.criarFilaPropostaConcluidaMsNotificacao())
                .to(configExchanges.criarFanoutExchangePropostaConcluida());
    }
}
