package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Erabiltzaile;

import java.util.Optional;

public interface ErabiltzaileRepository extends JpaRepository<Erabiltzaile, String> {
    Optional<Erabiltzaile> findByUsername(String username);
}

