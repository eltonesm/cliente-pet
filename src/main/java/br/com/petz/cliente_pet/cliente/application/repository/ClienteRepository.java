package br.com.petz.cliente_pet.cliente.application.repository;

import br.com.petz.cliente_pet.cliente.Cliente;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository {
    Cliente salva(Cliente cliente);
}