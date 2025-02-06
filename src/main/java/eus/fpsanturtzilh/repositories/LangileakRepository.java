package eus.fpsanturtzilh.repositories;

import eus.fpsanturtzilh.models.Langileak;
import eus.fpsanturtzilh.models.Taldeak;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LangileakRepository extends JpaRepository<Langileak, Integer> {

	@Query("SELECT l FROM Langileak l WHERE l.data.ezabatze_data IS NULL")
	List<Langileak> findAllNotDeleted();

	@Query("SELECT l FROM Langileak l WHERE l.data.ezabatze_data IS NOT NULL")
	List<Langileak> findAllDeleted();
}
