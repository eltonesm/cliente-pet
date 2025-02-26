package br.com.petz.cliente_pet.cliente.application.service;

import br.com.petz.cliente_pet.cliente.application.api.ClienteRequest;
import br.com.petz.cliente_pet.cliente.application.repository.ClienteRepository;
import br.com.petz.cliente_pet.cliente.domain.Cliente;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClienteApplicationServiceTest {

    @InjectMocks
    ClienteApplicationService clienteApplicationService;

    @Mock
    ClienteRepository clienteRepository;

    @Test
    @DisplayName("Deve salvar cliente")
    void deveSalvarCliente() {

        //DADO - GIVEN
        ClienteRequest clienteRequest = DataHelper.clienteRequest();
        Cliente cliente = new Cliente(clienteRequest);

        //QUANDO - WHEN
        when(clienteRepository.salva(any(Cliente.class))).thenReturn(cliente);
        clienteApplicationService.criaCliente(clienteRequest);

        //ENTAO - THEN
        verify(clienteRepository, times(1)).salva(any(Cliente.class));
    }
}