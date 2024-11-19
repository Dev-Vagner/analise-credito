package br.com.vbruno.proposta.listener;

import br.com.vbruno.proposta.dto.response.PropostaResponseDTO;
import br.com.vbruno.proposta.entity.Proposta;
import br.com.vbruno.proposta.mapper.PropostaMapper;
import br.com.vbruno.proposta.repository.PropostaRepository;
import br.com.vbruno.proposta.service.websocket.WebSocketService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PropostaConcluidaListener {

    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private WebSocketService webSocketService;

    @RabbitListener(queues = "${rabbitmq.proposta-concluida.ms-proposta.queue}")
    public void propostaConcluida(Proposta proposta) {
        propostaRepository.atualizarProposta(proposta.getId(), proposta.getAprovada(), proposta.getObservacao());

        PropostaResponseDTO propostaResponseDTO = PropostaMapper.INSTANCE.convertEntityToDTO(proposta);
        webSocketService.notificar(propostaResponseDTO);
    }
}
