package eus.fpsanturtzilh.repositories;

import eus.fpsanturtzilh.models.Taldeak;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaldeakRepository extends JpaRepository<Taldeak, String> {

	Optional<Taldeak> findByKodea(String kodea);

}

