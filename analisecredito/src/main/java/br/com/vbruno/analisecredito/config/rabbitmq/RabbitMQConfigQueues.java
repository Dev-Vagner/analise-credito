package br.com.vbruno.analisecredito.config.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfigQueues {

    @Value("${rabbitmq.proposta-pendente.ms-analise-credito.queue}")
    private String filaPropostaPendenteMsAnaliseCredito;

    @Value("${rabbitmq.proposta-pendente.ms-analise-credito.dlq}")
    private String dlqPropostaPendenteMsAnaliseCredito;

    @Value("${rabbitmq.proposta-pendente.ms-analise-credito.dlx}")
    private String dlxPropostaPendenteMsAnaliseCredito;

    @Bean
    public Queue criarFilaPropostaPendenteMsAnaliseCredito() {
        return QueueBuilder.durable(filaPropostaPendenteMsAnaliseCredito)
                .deadLetterExchange(dlxPropostaPendenteMsAnaliseCredito).build();
    }

    @Bean
    public Queue criarFilaPropostaPendenteMsAnaliseCreditoDlq() {
        return QueueBuilder.durable(dlqPropostaPendenteMsAnaliseCredito).build();
    }
}
