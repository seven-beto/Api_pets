package adocao.pets.repository;

import adocao.pets.entity.Pets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryPet extends JpaRepository<Pets, Long> {
}
