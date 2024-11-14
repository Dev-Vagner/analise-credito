package br.com.vbruno.proposta.controller;


import br.com.vbruno.proposta.dto.request.PropostaRequestDTO;
import br.com.vbruno.proposta.dto.response.PropostaResponseDTO;
import br.com.vbruno.proposta.service.proposta.CadastrarPropostaService;
import br.com.vbruno.proposta.service.proposta.ListarPropostasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/proposta")
public class PropostaController {

    @Autowired
    private CadastrarPropostaService cadastrarPropostaService;

    @Autowired
    private ListarPropostasService listarPropostasService;

    @PostMapping
    public ResponseEntity<PropostaResponseDTO> cadastrar(@RequestBody PropostaRequestDTO request) {
        PropostaResponseDTO response = cadastrarPropostaService.cadastrar(request);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri())
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<PropostaResponseDTO>> listarPropostas() {
        return ResponseEntity.ok(listarPropostasService.listar());
    }
}
