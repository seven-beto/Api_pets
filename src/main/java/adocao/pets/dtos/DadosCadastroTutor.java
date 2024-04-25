package adocao.pets.dtos;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroTutor(

        @NotBlank(message = "Nome obrigatorio")
        String nome,

        @NotBlank(message = "Email obrigatorio")
        String email) {
}
