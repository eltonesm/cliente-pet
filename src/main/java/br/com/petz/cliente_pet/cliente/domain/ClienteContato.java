package br.com.petz.cliente_pet.cliente.domain;

import br.com.petz.cliente_pet.cliente.application.api.ClienteAlteracaoRequest;
import br.com.petz.cliente_pet.cliente.application.api.ClienteRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClienteContato {
    @NotBlank
    private String whatssap;
    private String telefone;
    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    public ClienteContato(ClienteRequest clienteRequest) {
        this.whatssap = clienteRequest.getWhatssap();
        this.telefone = clienteRequest.getTelefone();
        this.email = clienteRequest.getEmail();
    }

    public ClienteContato(ClienteAlteracaoRequest clienteAlteracaoRequest) {
        this.whatssap = clienteAlteracaoRequest.getWhatssap();
        this.telefone = clienteAlteracaoRequest.getTelefone();
    }
}
