package br.com.petz.cliente_pet.cliente.application.service;

import br.com.petz.cliente_pet.cliente.application.api.ClienteAlteracaoRequest;
import br.com.petz.cliente_pet.cliente.application.api.ClienteDetalhadoResponse;
import br.com.petz.cliente_pet.cliente.application.api.ClienteListResponse;
import br.com.petz.cliente_pet.cliente.application.api.ClienteRequest;
import br.com.petz.cliente_pet.cliente.application.repository.ClienteRepository;
import br.com.petz.cliente_pet.cliente.domain.Cliente;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClienteApplicationServiceTest {

    @InjectMocks
    ClienteApplicationService clienteApplicationService;

    @Mock
    ClienteRepository clienteRepository;

    @DisplayName("Cria cliente com sucesso")
    @Test
    void criarClienteComSucesso() {

        //DADO - GIVEN
        ClienteRequest clienteRequest = DataHelper.clienteRequest();
        Cliente cliente = DataHelper.criaCliente();

        //QUANDO - WHEN
        when(clienteRepository.salva(any(Cliente.class))).thenReturn(cliente);
        clienteApplicationService.criaCliente(clienteRequest);

        //ENTAO - THEN
        assertNotNull(cliente.getCpf());
        assertEquals(clienteRequest.getCpf(), cliente.getCpf());
        verify(clienteRepository, times(1)).salva(any(Cliente.class));
    }

    @DisplayName("Cria cliente com erro no repositório")
    @Test
    void criaCliente_Excecao() {

        // Arrange
        ClienteRequest clienteRequest = DataHelper.clienteRequest();

        // Mock do repositório lançando uma exceção
        when(clienteRepository.salva(any(Cliente.class))).thenThrow(new RuntimeException("Erro de banco de dados"));

        // Act & Assert
        assertThrows(RuntimeException.class, () -> clienteApplicationService.criaCliente(clienteRequest));
        verify(clienteRepository).salva(any(Cliente.class)); // Verifica se o método salva foi chamado
    }

    @DisplayName("Busca todos os clinetes com sucesso")
    @Test
    void buscaTodosClientesComSucesso() {

        List<Cliente> clientes = Arrays.asList(DataHelper.criaCliente(), DataHelper.criaCliente(), DataHelper.criaCliente());
        when(clienteRepository.buscaTodosClientes()).thenReturn(clientes);

        List<ClienteListResponse> response = clienteApplicationService.buscaTodosClientes();

        assertNotNull(response);
        assertEquals(clientes.size(), response.size());
        verify(clienteRepository, times(1)).buscaTodosClientes();
    }

    @DisplayName("Busca todos os clientes sem clientes no repositório")
    @Test
    void buscaTodosClientessemClientes() {

        List<Cliente> clientes = Collections.emptyList();
        when(clienteRepository.buscaTodosClientes()).thenReturn(clientes);

        List<ClienteListResponse> response = clienteApplicationService.buscaTodosClientes();

        assertNotNull(response);
        assertTrue(response.isEmpty());
        verify(clienteRepository, times(1)).buscaTodosClientes();
    }

    @DisplayName("Deve buscar cliente atraves do ID com Sucesso")
    @Test
    void deveBuscarClienteAtravesIdComSucesso() {

        //DADO - GIVEN
        UUID idCliente = UUID.randomUUID();
        Cliente cliente = DataHelper.criaCliente();
        when(clienteRepository.buscaClienteAtravesId(idCliente)).thenReturn(cliente);

        //QUANDO - WHEN
        ClienteDetalhadoResponse response = clienteApplicationService.buscaClienteAtravesId(idCliente);

        //ENTÃO - THEN
        assertNotNull(response);
        assertEquals(cliente.getNomeCompleto(), response.getNomeCompleto());
        verify(clienteRepository, times(1)).buscaClienteAtravesId(idCliente);
    }

    @DisplayName("Busca cliente Atraves ID Com erro no repositorio")
    @Test
    void buscaClienteComErroNoRepositorio() {
        //DADO - GIVEN
        UUID idCliente = UUID.randomUUID();
        when(clienteRepository.buscaClienteAtravesId(idCliente)).thenThrow(new RuntimeException("Erro no banco de dados"));

        //QUANDO & ENTÂO - WhEN & THEN
        assertThrows(RuntimeException.class, () -> clienteApplicationService.deletaClienteAtravesId(idCliente));
        verify(clienteRepository, times(1)).buscaClienteAtravesId(idCliente);
    }

    @DisplayName("Deleta cliente atravesID com Sucesso")
    @Test
    void deveDeletaClienteAtravesId() {

        //DADO - GIVEN
        UUID idCliente = UUID.randomUUID();
        Cliente cliente = DataHelper.criaCliente();
        when(clienteRepository.buscaClienteAtravesId(idCliente)).thenReturn(cliente);

        //QUANDO - WHEN
        clienteApplicationService.deletaClienteAtravesId(idCliente);

        //ENTÃO - THEN
        verify(clienteRepository, times(1)).buscaClienteAtravesId(idCliente);
        verify(clienteRepository, times(1)).delataCliente(cliente);
    }

    @DisplayName("Erro ao deletar cliente atravesID")
    @Test
    void erroAoDeletarClienteAtravesID() {
        UUID idCliente = UUID.randomUUID();
        Cliente cliente = DataHelper.criaCliente();
        when(clienteRepository.buscaClienteAtravesId(idCliente)).thenReturn(cliente);
        doThrow(new RuntimeException("Erro ao deletar cliente")).when(clienteRepository).delataCliente(cliente);

        //QUANDO & ENTÃO - WHEN & THEN
        assertThrows(RuntimeException.class, () -> clienteApplicationService.deletaClienteAtravesId(idCliente));
        verify(clienteRepository, times(1)).buscaClienteAtravesId(idCliente);
        verify(clienteRepository, times(1)).delataCliente(cliente);
    }

    @DisplayName("Deve alterar o cliente com sucesso")
    @Test
    void deveAlteraClienteComSucesso() {
        //DADO - GIVEN
        UUID idCliente = UUID.randomUUID();
        ClienteAlteracaoRequest clienteAlteracaoRequest = new ClienteAlteracaoRequest("Marques", LocalDate.of(1090, 5, 20), true, "1111111111", "76687686876");
        Cliente cliente = DataHelper.criaCliente();

        //Simula que o cliente foi encontrado no repositorio
        when(clienteRepository.buscaClienteAtravesId(idCliente)).thenReturn(cliente);
        when(clienteRepository.salva(cliente)).thenReturn(cliente);

        //QUANDO - WHEN
        clienteApplicationService.patchAlteraCliente(idCliente, clienteAlteracaoRequest);

        //ENTÃO -THEN
        assertEquals(clienteAlteracaoRequest.getNomeCompleto(), cliente.getNomeCompleto());
        verify(clienteRepository, times(1)).buscaClienteAtravesId(idCliente);
        verify(clienteRepository, times(1)).salva(cliente);
    }
}