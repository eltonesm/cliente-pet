package br.com.petz.cliente_pet.pet.application.service;

import br.com.petz.cliente_pet.cliente.application.service.ClienteService;
import br.com.petz.cliente_pet.pet.application.api.PetClienteDetalheResponse;
import br.com.petz.cliente_pet.pet.application.api.PetClienteListResponse;
import br.com.petz.cliente_pet.pet.application.api.PetRequest;
import br.com.petz.cliente_pet.pet.application.api.PetResponse;
import br.com.petz.cliente_pet.pet.application.repository.PetRepository;
import br.com.petz.cliente_pet.pet.domain.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class PetApplicationService implements PetService {
    private final ClienteService clienteService;
    private final PetRepository petRepository;

    @Override
    public PetResponse criaPet(UUID idCliente, PetRequest petRequest) {
        log.info("[Start]PetApplicationService - criaPet");
        clienteService.buscaClienteAtravesId(idCliente);
        Pet pet = petRepository.salvaPet(new Pet(idCliente, petRequest));
        log.info("[Finish]PetApplicationService - criaPet");
        return new PetResponse(pet.getIdPet());
    }

    @Override
    public List<PetClienteListResponse> buscaPetsDoClienteComId(UUID idCliente) {
        log.info("[Start]PetApplicationService - buscaPetsDoClienteComId");
        clienteService.buscaClienteAtravesId(idCliente);
        List <Pet> petsDoCliente = petRepository.buscaPetsDoClienteComId(idCliente);
        log.info("[Finish]PetApplicationService - buscaPetsDoClienteComId");
        return PetClienteListResponse.converte(petsDoCliente);
    }

    @Override
    public PetClienteDetalheResponse buscaPetDoClienteComId(UUID idCliente, UUID idPet) {
        log.info("[Start]PetApplicationService - buscaPetDoClienteComId");
        clienteService.buscaClienteAtravesId(idCliente);
        Pet pet = petRepository.buscaPetPeloId(idPet);
        log.info("[Finish]PetApplicationService - buscaPetDoClienteComId");
        return new PetClienteDetalheResponse(pet);
    }

    @Override
    public void delataPetDoClienteComId(UUID idCliente, UUID idPet) {
        log.info("[Start]PetApplicationService - delataPetDoClienteComId");
        clienteService.buscaClienteAtravesId(idCliente);
        Pet pet = petRepository.buscaPetPeloId(idPet);
        petRepository.deletaPet(pet);
        log.info("[Finish]PetApplicationService - delataPetDoClienteComId");
    }
}