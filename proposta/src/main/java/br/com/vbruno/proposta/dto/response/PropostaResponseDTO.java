package br.com.vbruno.proposta.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropostaResponseDTO {

    private Long id;

    private String nome;

    private String sobrenome;

    private String email;

    private String telefone;

    private String cpf;

    private BigDecimal renda;

    private String valorSolicitadoFmt;

    private int prazoPagamento;

    private Boolean aprovada;

    private String observacao;
}
