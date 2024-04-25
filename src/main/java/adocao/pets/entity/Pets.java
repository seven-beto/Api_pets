package adocao.pets.entity;


import adocao.pets.dtos.DadosAtualizarPet;
import adocao.pets.dtos.DadosCadastroPet;
import adocao.pets.enumeration.TipoPet;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "pets")
@Entity(name = "Pets")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Pets {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    private Integer idade;

    @Enumerated
    private TipoPet tipo;

    public Pets(DadosCadastroPet dados) {
        this.nome = dados.nome();
        this.idade = dados.idade();
        this.tipo = dados.tipo();
    }

    public void updated(DadosAtualizarPet dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.idade() != null){
            this.idade = dados.idade();
        }
        if(dados.tipo() != null){
            this.tipo = dados.tipo();
        }
    }
}
