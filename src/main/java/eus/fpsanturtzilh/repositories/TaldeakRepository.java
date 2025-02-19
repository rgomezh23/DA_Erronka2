package eus.fpsanturtzilh.repositories;

import eus.fpsanturtzilh.models.Taldeak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface TaldeakRepository extends JpaRepository<Taldeak, String> {

	Optional<Taldeak> findByKodea(String kodea);

	@Query("SELECT t FROM Taldeak t WHERE t.data.ezabatze_data IS NULL")
	List<Taldeak> findAllNotDeleted();

	@Query("SELECT t FROM Taldeak t WHERE t.data.ezabatze_data IS NOT NULL")
	List<Taldeak> findAllDeleted();
}
