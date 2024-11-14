package br.com.vbruno.analisecredito.service.notificacao;

import br.com.vbruno.analisecredito.domain.Proposta;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoRabbitMQService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void notificar(String exchange, Proposta proposta) {
        rabbitTemplate.convertAndSend(exchange, "", proposta);
    }
}
