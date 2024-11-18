package br.com.petz.cliente_pet.cliente.application.api;

import br.com.petz.cliente_pet.cliente.domain.Sexo;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Value
@AllArgsConstructor
public class ClienteRequest {

    @NotBlank
    private String nomeCompleto;
    private Sexo sexo;
    @NotNull
    private LocalDate dataNascimento;
    @CPF
    private String cpf;
    @NotNull
    private Boolean aceitaTermos;

    @NotBlank
    private String whatssap;

    private String telefone;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;
}