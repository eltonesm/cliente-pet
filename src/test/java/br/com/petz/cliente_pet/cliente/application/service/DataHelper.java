package br.com.petz.cliente_pet.cliente.application.service;

import br.com.petz.cliente_pet.cliente.application.api.ClienteRequest;
import br.com.petz.cliente_pet.cliente.domain.Cliente;
import br.com.petz.cliente_pet.cliente.domain.Sexo;

import java.time.LocalDate;

public class DataHelper {

    // Método para criar uma instância de Cliente
    public static Cliente criaCliente() {
        return new Cliente(clienteRequest());
    }

    // Método para criar uma instância de ClienteRequest
    public static ClienteRequest clienteRequest() {
        return new ClienteRequest(
                "Elton",
                Sexo.MASCULINO,
                LocalDate.of(1985, 8, 21),
                "83885897504",
                true,
                "73988888888",
                "9999999999",
                "eltonesm@gmail.com");
    }
}
