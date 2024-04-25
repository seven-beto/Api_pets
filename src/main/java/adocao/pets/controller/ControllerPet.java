package adocao.pets.controller;


import adocao.pets.dtos.DadosAtualizarPet;
import adocao.pets.dtos.DadosCadastroPet;
import adocao.pets.entity.Pets;
import adocao.pets.repository.RepositoryPet;
import adocao.pets.service.ServicePets;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pet")
public class ControllerPet {

    @Autowired
    private RepositoryPet repository;

    @Autowired
    private ServicePets servicePets;

    @GetMapping
    public ResponseEntity all(){
        var allList = repository.findAll();
        return new ResponseEntity<>(allList, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastro(@RequestBody @Valid DadosCadastroPet dados){
        var cadastrar = repository.save(new Pets(dados));
        return new ResponseEntity<>(cadastrar, HttpStatus.CREATED);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DadosAtualizarPet dados){
        this.servicePets.atualizarPet(dados);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
