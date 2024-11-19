package br.com.vbruno.notificacao.config.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfigQueues {

    @Value("${rabbitmq.proposta-pendente.ms-notificacao.queue}")
    private String filaPropostaPendenteMsNotificacao;

    @Value("${rabbitmq.proposta-concluida.ms-notificacao.queue}")
    private String filaPropostaConcluidaMsNotificacao;

    @Bean
    public Queue criarFilaPropostaPendenteMsNotificacao() {
        return QueueBuilder.durable(filaPropostaPendenteMsNotificacao).build();
    }

    @Bean
    public Queue criarFilaPropostaConcluidaMsNotificacao() {
        return QueueBuilder.durable(filaPropostaConcluidaMsNotificacao).build();
    }
}
