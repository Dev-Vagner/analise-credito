package br.com.vbruno.proposta.service.proposta;

import br.com.vbruno.proposta.dto.request.PropostaRequestDTO;
import br.com.vbruno.proposta.dto.response.PropostaResponseDTO;
import br.com.vbruno.proposta.entity.Proposta;
import br.com.vbruno.proposta.mapper.PropostaMapper;
import br.com.vbruno.proposta.repository.PropostaRepository;
import br.com.vbruno.proposta.service.notificacao.NotificacaoRabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CadastrarPropostaService {

    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private NotificacaoRabbitMQService notificacaoRabbitMQService;

    @Value("${rabbitmq.proposta-pendente.exchange}")
    private String exchangePropostaPendente;

    public PropostaResponseDTO cadastrar(PropostaRequestDTO request) {
        Proposta proposta = PropostaMapper.INSTANCE.convertDTOToProposta(request);

        propostaRepository.save(proposta);

        notificarRabbitMQ(proposta);

        return PropostaMapper.INSTANCE.convertEntityToDTO(proposta);
    }

    private void notificarRabbitMQ(Proposta proposta) {
        try {
            notificacaoRabbitMQService.notificar(proposta, exchangePropostaPendente);
        } catch (RuntimeException ex) {
            proposta.setIntegrada(false);
            propostaRepository.save(proposta);
        }
    }
}
