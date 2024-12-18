package Repositoty;

import org.springframework.data.jpa.repository.JpaRepository;

import Models.Erabiltzaile;

public interface ErabiltzaileRepository extends JpaRepository<Erabiltzaile, String> {
	Erabiltzaile findByIzena(String izena);
	Erabiltzaile findByPasahitza(String pasahitza);
}
