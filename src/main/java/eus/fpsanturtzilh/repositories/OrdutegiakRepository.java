package eus.fpsanturtzilh.repositories;

import eus.fpsanturtzilh.models.Ordutegiak;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdutegiakRepository extends JpaRepository<Ordutegiak, Integer> {

	@Query("SELECT o FROM Ordutegiak o WHERE o.data.ezabatze_data IS NULL")
	List<Ordutegiak> findAllNotDeleted();

	@Query("SELECT o FROM Ordutegiak o WHERE o.data.ezabatze_data IS NOT NULL")
	List<Ordutegiak> findAllDeleted();
}
