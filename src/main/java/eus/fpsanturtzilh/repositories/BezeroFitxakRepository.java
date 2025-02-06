package eus.fpsanturtzilh.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import eus.fpsanturtzilh.models.Bezero_fitxak;

@Repository
public interface BezeroFitxakRepository extends JpaRepository<Bezero_fitxak, Integer> {

	Optional<Bezero_fitxak> findById(Long id);

	@Query("SELECT b FROM Bezero_fitxak b WHERE b.data.ezabatze_data IS NULL")
	List<Bezero_fitxak> findAllNotDeleted();

	@Query("SELECT b FROM Bezero_fitxak b WHERE b.data.ezabatze_data IS NOT NULL")
	List<Bezero_fitxak> findAllDeleted();

}
