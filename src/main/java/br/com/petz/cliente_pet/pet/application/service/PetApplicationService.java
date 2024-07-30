package br.com.petz.cliente_pet.pet.application.service;

import br.com.petz.cliente_pet.pet.application.api.PetRequest;
import br.com.petz.cliente_pet.pet.application.api.PetResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class PetApplicationService implements PetService {
    @Override
    public PetResponse criaPet(UUID idCliente, PetRequest petRequest) {
        log.info("[Start]PetApplicationService - criaPet");
        log.info("[Finish]PetApplicationService - criaPet");
        return null;
    }
}