package br.com.vbruno.notificacao.listener;

import br.com.vbruno.notificacao.constante.MensagemConstante;
import br.com.vbruno.notificacao.domain.Proposta;
import br.com.vbruno.notificacao.service.NotificacaoEmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PropostaPendenteListener {

    @Autowired
    private NotificacaoEmailService notificacaoEmailService;

    @RabbitListener(queues = "${rabbitmq.proposta-pendente.queue}")
    public void propostaPendente(Proposta proposta) {
        String mensagem = String.format(MensagemConstante.PROPOSTA_EM_ANALISE, proposta.getUsuario().getNome());
        notificacaoEmailService.notificar(proposta.getUsuario().getEmail(), mensagem);
    }

    @RabbitListener(queues = "${rabbitmq.proposta-concluida.queue}")
    public void propostaConcluida(Proposta proposta) {
        String mensagem = String.format(MensagemConstante.PROPOSTA_CONCLUIDA, proposta.getUsuario().getNome());
        notificacaoEmailService.notificar(proposta.getUsuario().getEmail(), mensagem);
    }
}
