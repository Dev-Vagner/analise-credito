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

    @Value("${rabbitmq.proposta-pendente.ms-notificacao.dlq}")
    private String dlqPropostaPendenteMsNotificacao;

    @Value("${rabbitmq.proposta-pendente.ms-notificacao.dlx}")
    private String dlxPropostaPendenteMsNotificacao;

    @Value("${rabbitmq.proposta-concluida.ms-notificacao.dlq}")
    private String dlqPropostaConcluidaMsNotificacao;

    @Value("${rabbitmq.proposta-concluida.ms-notificacao.dlx}")
    private String dlxPropostaConcluidaMsNotificacao;

    @Bean
    public Queue criarFilaPropostaPendenteMsNotificacao() {
        return QueueBuilder.durable(filaPropostaPendenteMsNotificacao)
                .deadLetterExchange(dlxPropostaPendenteMsNotificacao).build();
    }

    @Bean
    public Queue criarFilaPropostaConcluidaMsNotificacao() {
        return QueueBuilder.durable(filaPropostaConcluidaMsNotificacao)
                .deadLetterExchange(dlxPropostaConcluidaMsNotificacao).build();
    }

    @Bean
    public Queue criarFilaPropostaPendenteMsNotificacaoDlq() {
        return QueueBuilder.durable(dlqPropostaPendenteMsNotificacao).build();
    }

    @Bean
    public Queue criarFilaPropostaConcluidaMsNotificacaoDlq() {
        return QueueBuilder.durable(dlqPropostaConcluidaMsNotificacao).build();
    }
}
