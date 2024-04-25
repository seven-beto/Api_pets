package adocao.pets.entity;


import adocao.pets.dtos.DadosAtualizarTutor;
import adocao.pets.dtos.DadosCadastroTutor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "tutor")
@Entity(name = "Tutor")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    public Tutor(DadosCadastroTutor dados) {
        this.nome = dados.nome();
        this.email = dados.email();
    }

    public void updated(DadosAtualizarTutor dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.email() != null){
            this.email = dados.email();
        }
    }
}
