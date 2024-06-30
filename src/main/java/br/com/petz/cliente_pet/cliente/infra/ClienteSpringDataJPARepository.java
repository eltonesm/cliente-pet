package br.com.petz.cliente_pet.cliente.infra;

import br.com.petz.cliente_pet.cliente.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteSpringDataJPARepository extends JpaRepository<Cliente, UUID> {
}
