package br.com.petz.cliente_pet.pet.application.api;

import br.com.petz.cliente_pet.pet.domain.Porte;
import br.com.petz.cliente_pet.pet.domain.SexoPet;
import br.com.petz.cliente_pet.pet.domain.TipoPet;
import lombok.Value;

import java.time.LocalDate;

@Value
public class PetClienteDetalheResponse {
    private String nomePet;
    private Porte porte;
    private TipoPet tipo;
    private String microchip;
    private String raca;
    private SexoPet sexo;
    private String pelagemCor;
    private LocalDate dataNascimento;
    private String rga;
    private Integer peso;
}