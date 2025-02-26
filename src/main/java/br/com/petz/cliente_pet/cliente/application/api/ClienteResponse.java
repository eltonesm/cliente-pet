package br.com.petz.cliente_pet.cliente.application.api;

import br.com.petz.cliente_pet.cliente.domain.Cliente;
import lombok.Value;

import java.util.UUID;

@Value
public class ClienteResponse {
    private UUID idCliente;

    public ClienteResponse(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
    }
}