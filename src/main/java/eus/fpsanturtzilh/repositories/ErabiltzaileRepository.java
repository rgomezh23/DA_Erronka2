package eus.fpsanturtzilh.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import eus.fpsanturtzilh.models.Erabiltzaile;

public interface ErabiltzaileRepository extends JpaRepository<Erabiltzaile, String> {
	Optional<Erabiltzaile> findByUsername(String username);
}
