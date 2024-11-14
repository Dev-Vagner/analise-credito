package br.com.vbruno.proposta.service.proposta;

import br.com.vbruno.proposta.dto.response.PropostaResponseDTO;
import br.com.vbruno.proposta.mapper.PropostaMapper;
import br.com.vbruno.proposta.repository.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarPropostasService {

    @Autowired
    private PropostaRepository propostaRepository;

    public List<PropostaResponseDTO> listar() {
        return PropostaMapper.INSTANCE.convertListEntityToListDTO(propostaRepository.findAll());
    }
}
