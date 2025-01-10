package eus.fpsanturtzilh.repositories;

import eus.fpsanturtzilh.models.Material_maileguak;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialMaileguakRepository extends JpaRepository<Material_maileguak, Integer> {

    @EntityGraph(attributePaths = {"materiala", "langilea"}) // Carga tanto materiala como langilea
    List<Material_maileguak> findAll();

    Optional<Material_maileguak> findById(Long id);
}
