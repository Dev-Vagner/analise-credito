package br.com.vbruno.proposta.service.notificacao;

import br.com.vbruno.proposta.entity.Proposta;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoRabbitMQService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void notificar(Proposta proposta, String exchange) {
        rabbitTemplate.convertAndSend(exchange, "", proposta);
    }
}
