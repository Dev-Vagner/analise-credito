package br.com.vbruno.proposta.config.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfigQueues {

    @Value("${rabbitmq.proposta-concluida.ms-proposta.queue}")
    private String filaPropostaConcluidaMsProposta;

    @Value("${rabbitmq.proposta-concluida.ms-proposta.dlq}")
    private String dlqPropostaConcluidaMsProposta;

    @Value("${rabbitmq.proposta-concluida.ms-proposta.dlx}")
    private String dlxPropostaConcluidaMsProposta;

    @Bean
    public Queue criarFilaPropostaConcluidaMsProposta() {
        return QueueBuilder.durable(filaPropostaConcluidaMsProposta)
                .deadLetterExchange(dlxPropostaConcluidaMsProposta).build();
    }

    @Bean
    public Queue criarFilaPropostaConcluidaMsPropostaDlq() {
        return QueueBuilder.durable(dlqPropostaConcluidaMsProposta).build();
    }
}
