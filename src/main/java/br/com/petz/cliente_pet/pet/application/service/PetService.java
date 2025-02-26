package br.com.petz.cliente_pet.pet.application.service;

import br.com.petz.cliente_pet.pet.application.api.*;

import java.util.List;
import java.util.UUID;

public interface PetService {
    petResponse criaPet(UUID idCliente, PetRequest petRequest);
    List<PetClienteListResponse> buscaPetsDoClienteComId(UUID idCliente);
    PetClienteDetalheResponse buscaPetDoClienteComId(UUID idCliente, UUID idPet);
    void delataPetDoClienteComId(UUID idCliente, UUID idPet);
    void alteraPetDoClienteComId(UUID idCliente, UUID idPet, PetAlteracaoRequest petAlteracaoRequest);
}