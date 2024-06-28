package br.com.petz.cliente_pet.cliente.infra;

import br.com.petz.cliente_pet.cliente.Cliente;
import br.com.petz.cliente_pet.cliente.application.repository.ClienteRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
public class ClienteInfraRepository implements ClienteRepository {
    @Override
    public Cliente salva(Cliente cliente) {
       log.info("[Inicia] ClienteInfraRepository - salva");
       
       log.info("[Finaliza] ClienteInfraRepository - salva");
        return cliente;
    }
}
