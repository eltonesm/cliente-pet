package br.com.petz.cliente_pet.pet.application.api;

import br.com.petz.cliente_pet.pet.application.service.PetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class PetController implements PetApi {

    private final PetService petSetvice;

    @Override
    public PetResponse postPet(UUID idCliente, PetRequest petRequest) {
        log.info("[start]PetController - postPet");
        log.info("[idCliente]{}", idCliente);
        PetResponse pet = petSetvice.criaPet(idCliente, petRequest);
        log.info("[Finish]PetController - postPet");
        return pet;
    }

    @Override
    public List<PetClienteListResponse> getPetsDoClienteComId(UUID idCliente) {
        log.info("[Start]PetController - getPetsdoClienteComId");
        log.info("[idCliente]{}", idCliente);
        List<PetClienteListResponse> petsDoCliente = petSetvice.buscaPetsDoClienteComId(idCliente);
        log.info("[Finish]PetController - getPetsdoClienteComId");
        return petsDoCliente;
    }

    @Override
    public PetClienteDetalheResponse getPetDoClienteComId(UUID idCliente, UUID idPet) {
        log.info("[Start]PetController - getPetDoClienteComId");
        log.info("[IdCliente]{} - [idPet]{}", idCliente, idPet);
        PetClienteDetalheResponse pet = petSetvice.buscaPetDoClienteComId(idCliente, idPet);
        log.info("[Finish]PetController - getPetDoClienteComId");
        return pet;
    }

    @Override
    public void deletaPetDoClienteComId(UUID idCliente, UUID idPet) {
        log.info("[Start]PetController - deletaPetDoClienteComId");
        log.info("[idCliente]{} - [idPet]{}", idCliente, idPet);
        log.info("[Finish]PetController - deletaPetDoClienteComId");
    }
}