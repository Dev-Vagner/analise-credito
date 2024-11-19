package br.com.vbruno.notificacao.listener;

import br.com.vbruno.notificacao.constante.MensagemConstante;
import br.com.vbruno.notificacao.domain.Proposta;
import br.com.vbruno.notificacao.service.NotificacaoEmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PropostaConcluidaListener {

    @Autowired
    private NotificacaoEmailService notificacaoEmailService;

    @RabbitListener(queues = "${rabbitmq.proposta-concluida.ms-notificacao.queue}")
    public void propostaConcluida(Proposta proposta) {
        String mensagem = proposta.getAprovada() ?
                String.format(MensagemConstante.PROPOSTA_APROVADA, proposta.getUsuario().getNome()) :
                String.format(MensagemConstante.PROPOSTA_NEGADA, proposta.getUsuario().getNome());

        notificacaoEmailService.notificar(proposta.getUsuario().getEmail(), mensagem);
    }
}
