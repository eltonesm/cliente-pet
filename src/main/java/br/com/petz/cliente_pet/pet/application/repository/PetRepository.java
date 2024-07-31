package br.com.petz.cliente_pet.pet.application.repository;

import br.com.petz.cliente_pet.pet.domain.Pet;

public interface PetRepository {
    Pet salvaPet(Pet pet);
}