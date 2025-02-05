package eus.fpsanturtzilh.repositories;

import eus.fpsanturtzilh.models.Materialak;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MaterialakRepository extends JpaRepository<Materialak, Integer> {
 
    Optional<Materialak> findById(Integer id);
}
