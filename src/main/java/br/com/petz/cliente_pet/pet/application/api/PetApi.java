package br.com.petz.cliente_pet.pet.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/cliente/{idCliente}/pet")
public interface PetApi {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    PetResponse postPet(@PathVariable UUID idCliente, @Valid @RequestBody PetRequest petRequest);
}
