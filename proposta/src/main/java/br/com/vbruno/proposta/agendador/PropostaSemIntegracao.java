package br.com.vbruno.proposta.agendador;

import br.com.vbruno.proposta.entity.Proposta;
import br.com.vbruno.proposta.repository.PropostaRepository;
import br.com.vbruno.proposta.service.notificacao.NotificacaoRabbitMQService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class PropostaSemIntegracao {

    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private NotificacaoRabbitMQService notificacaoRabbitMQService;

    @Value("${rabbitmq.proposta-pendente.exchange}")
    private String exchangePropostaPendente;

    private final Logger logger = LoggerFactory.getLogger(PropostaSemIntegracao.class);

    @Scheduled(fixedDelay = 10, timeUnit = TimeUnit.SECONDS)
    public void buscarPropostasSemIntegracao() {
        propostaRepository.findAllByIntegradaIsFalse().forEach(proposta -> {
            try {
                notificacaoRabbitMQService.notificar(proposta, exchangePropostaPendente);
                atualizarProposta(proposta);
            } catch (RuntimeException ex) {
                logger.error(ex.getMessage());
            }
        });
    }

    public void atualizarProposta(Proposta proposta) {
        proposta.setIntegrada(true);
        propostaRepository.save(proposta);
    }
}
