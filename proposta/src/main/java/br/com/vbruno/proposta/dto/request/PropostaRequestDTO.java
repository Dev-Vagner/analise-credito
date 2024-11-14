package br.com.vbruno.proposta.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropostaRequestDTO {

    private String nome;

    private String sobrenome;

    private String email;

    private String telefone;

    private String cpf;

    private BigDecimal renda;

    private BigDecimal valorSolicitado;

    private int prazoPagamento;
}
