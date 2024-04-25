package adocao.pets.controller;


import adocao.pets.dtos.DadosAtualizarTutor;
import adocao.pets.dtos.DadosCadastroTutor;
import adocao.pets.entity.Tutor;
import adocao.pets.repository.RepositoryTutor;
import adocao.pets.service.ServicePets;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/tutores")
public class ControllerTutor {

    @Autowired
    private ServicePets service;

    @Autowired
    private RepositoryTutor repository;

    @GetMapping
    public ResponseEntity all(){
        var allList = repository.findAll();
        return new ResponseEntity<>(allList, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTutor dados){
        var cadastroTutor = repository.save(new Tutor(dados));
        return new ResponseEntity<>(cadastroTutor, HttpStatus.CREATED);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DadosAtualizarTutor dados){
        this.service.atualizar(dados);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
