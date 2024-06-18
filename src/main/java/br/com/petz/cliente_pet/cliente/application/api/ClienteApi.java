package br.com.petz.cliente_pet.cliente.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/cliente")
public interface ClienteApi{

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ClienteResponse postCliente(@RequestBody ClienteRequest clienteRequest);


}
