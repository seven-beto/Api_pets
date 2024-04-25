package adocao.pets.dtos;

import adocao.pets.enumeration.TipoPet;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPet(

        @NotBlank(message = "Nome obrigatorio")
        String nome,

        @NotNull(message = "Idade obrigatoria")
        Integer idade,


        TipoPet tipo) {
}
