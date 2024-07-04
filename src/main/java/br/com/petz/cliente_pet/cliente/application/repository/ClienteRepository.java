package br.com.petz.cliente_pet.cliente.application.repository;

import br.com.petz.cliente_pet.cliente.application.api.ClienteListResponse;
import br.com.petz.cliente_pet.cliente.domain.Cliente;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClienteRepository {
    Cliente salva(Cliente cliente);
    List<Cliente> buscaTodosClientes();
    Cliente buscaClienteAtravesId(UUID idCliente);
}
