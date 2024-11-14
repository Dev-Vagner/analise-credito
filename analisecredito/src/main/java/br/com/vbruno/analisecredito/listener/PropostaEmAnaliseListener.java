package br.com.vbruno.analisecredito.listener;

import br.com.vbruno.analisecredito.domain.Proposta;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PropostaEmAnaliseListener {

    @RabbitListener(queues = "${rabbitmq.proposta-pendente.queue}")
    public void propostaEmAnalise(Proposta proposta) {

    }
}
