package br.com.petz.cliente_pet.pet.application.api;

import br.com.petz.cliente_pet.pet.domain.Pet;
import lombok.Value;

import java.util.List;

@Value
public class PetClienteListResponse {
    
    public static List<PetClienteListResponse> converte(List<Pet> petsDoCliente) {
        return null;
    }
}
