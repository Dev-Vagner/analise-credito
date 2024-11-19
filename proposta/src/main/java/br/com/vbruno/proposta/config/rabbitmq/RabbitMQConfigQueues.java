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

    @Bean
    public Queue criarFilaPropostaConcluidaMsProposta() {
        return QueueBuilder.durable(filaPropostaConcluidaMsProposta).build();
    }
}
