package br.com.petz.cliente_pet.cliente.domain;

import br.com.petz.cliente_pet.cliente.application.api.ClienteAlteracaoRequest;
import br.com.petz.cliente_pet.cliente.application.api.ClienteRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "UUID", name = "idCliente", updatable = false, unique = true, nullable = false)
    private UUID idCliente;
    @NotBlank
    private String nomeCompleto;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @NotNull
    private LocalDate dataNascimento;
    @CPF
    @Column(unique = true)
    private String cpf;
    @NotNull
    private Boolean aceitaTermos;

    private LocalDateTime dataHoraDoCadastro;
    private LocalDateTime dataHoraDaUltimaAlteracao;

    @Embedded
    private ClienteContato contato;

    public Cliente(ClienteRequest clienteRequest) {
        this.nomeCompleto = clienteRequest.getNomeCompleto();
        this.sexo = clienteRequest.getSexo();
        this.dataNascimento = clienteRequest.getDataNascimento();
        this.cpf = clienteRequest.getCpf();
        this.aceitaTermos = clienteRequest.getAceitaTermos();
        this.dataHoraDoCadastro = LocalDateTime.now();
        this.contato = new ClienteContato(clienteRequest);
    }

    public void altera(ClienteAlteracaoRequest clienteAlteracaoRequest) {
        this.nomeCompleto = clienteAlteracaoRequest.getNomeCompleto();
        this.dataNascimento = clienteAlteracaoRequest.getDataNascimento();
        this.aceitaTermos = clienteAlteracaoRequest.getAceitaTermos();
        this.dataHoraDaUltimaAlteracao = LocalDateTime.now();
        this.contato = new ClienteContato(clienteAlteracaoRequest);
    }
}