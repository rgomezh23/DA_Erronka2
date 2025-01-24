package eus.fpsanturtzilh.repositories;

import eus.fpsanturtzilh.models.Materialak;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialakRepository extends JpaRepository<Materialak, Integer> {
 
	Optional<Materialak> findById(Long id);
}

