package eus.fpsanturtzilh.repositories;

import eus.fpsanturtzilh.models.Produktuak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProduktuRepository extends JpaRepository<Produktuak, Integer> {

	Optional<Produktuak> findById(int id);

	@Query("SELECT p FROM Produktuak p WHERE p.data.ezabatze_data IS NULL")
	List<Produktuak> findAllNotDeleted();

	@Query("SELECT p FROM Produktuak p WHERE p.data.ezabatze_data IS NOT NULL")
	List<Produktuak> findAllDeleted();
}
