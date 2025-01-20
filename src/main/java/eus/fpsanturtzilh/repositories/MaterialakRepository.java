package eus.fpsanturtzilh.repositories;

import eus.fpsanturtzilh.models.Materialak;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialakRepository extends JpaRepository<Materialak, Integer> {
    @EntityGraph(attributePaths = {"maileguak"})
    List<Materialak> findAll();

	Optional<Materialak> findById(Long id);
}

