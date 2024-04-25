package adocao.pets.service;


import adocao.pets.dtos.DadosAtualizarPet;
import adocao.pets.dtos.DadosAtualizarTutor;
import adocao.pets.entity.Pets;
import adocao.pets.entity.Tutor;
import adocao.pets.repository.RepositoryPet;
import adocao.pets.repository.RepositoryTutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicePets {

    @Autowired
    private RepositoryTutor repositoryTutor;

    private RepositoryPet repositoryPet;

    public Tutor atualizar(DadosAtualizarTutor dados){
        var update = repositoryTutor.getReferenceById(dados.id());
        update.updated(dados);
        return update;
    }

    public Pets atualizarPet(DadosAtualizarPet dados){
        var update =  repositoryPet.getReferenceById(dados.id());
        update.updated(dados);
        return update;
    }

}
