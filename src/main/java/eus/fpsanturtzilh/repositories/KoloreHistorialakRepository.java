package eus.fpsanturtzilh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import eus.fpsanturtzilh.models.Kolore_historialak;

import java.util.List;

public interface KoloreHistorialakRepository extends JpaRepository<Kolore_historialak, Integer> {

	@Query("SELECT k FROM Kolore_historialak k WHERE k.dataSimple.ezabatze_data IS NULL")
	List<Kolore_historialak> findAllNotDeleted();

	@Query("SELECT k FROM Kolore_historialak k WHERE k.dataSimple.ezabatze_data IS NOT NULL")
	List<Kolore_historialak> findAllDeleted();
}
