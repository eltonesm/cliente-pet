package br.com.petz.cliente_pet.pet.application.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class PetController implements PetApi {

    @Override
    public PetResponse postPet(UUID idCliente, PetRequest petRequest) {
       log.info("[start]PetController - postPet");
       log.info("[idCliente]{}", idCliente);
       log.info("[Finish]PetController - postPet");
        return null;
    }
}
