package adocao.pets.dtos;

import adocao.pets.enumeration.TipoPet;

public record DadosAtualizarPet(Long id, String nome, Integer idade, TipoPet tipo) {
}
