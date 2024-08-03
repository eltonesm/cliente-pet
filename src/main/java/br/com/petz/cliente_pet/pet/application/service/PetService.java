package br.com.petz.cliente_pet.pet.application.service;

import br.com.petz.cliente_pet.pet.application.api.PetClienteDetalheResponse;
import br.com.petz.cliente_pet.pet.application.api.PetClienteListResponse;
import br.com.petz.cliente_pet.pet.application.api.PetRequest;
import br.com.petz.cliente_pet.pet.application.api.PetResponse;

import java.util.List;
import java.util.UUID;

public interface PetService {
    PetResponse criaPet(UUID idCliente, PetRequest petRequest);
    List<PetClienteListResponse> buscaPetsDoClienteComId(UUID idCliente);
    PetClienteDetalheResponse buscaPetDoClienteComId(UUID idCliente, UUID idPet);
    void delataPetDoClienteComId(UUID idCliente, UUID idPet);
}