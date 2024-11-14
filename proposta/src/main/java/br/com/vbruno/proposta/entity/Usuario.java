package br.com.vbruno.proposta.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String sobrenome;

    private String email;

    private String cpf;

    private String telefone;

    private BigDecimal renda;

    @OneToOne(mappedBy = "usuario")
    @JsonBackReference
    private Proposta proposta;
}
