package br.com.petz.cliente_pet.comunicacao.application.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ZApiRequest {
    private String phone;
    private String message;
}
