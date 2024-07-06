package br.com.petz.cliente_pet.cliente.application.api;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class ClienteResponse {
    private UUID idCliente;
}