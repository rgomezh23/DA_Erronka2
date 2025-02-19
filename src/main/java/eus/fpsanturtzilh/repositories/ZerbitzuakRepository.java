package eus.fpsanturtzilh.repositories;

import eus.fpsanturtzilh.models.Zerbitzuak;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ZerbitzuakRepository extends JpaRepository<Zerbitzuak, Integer> {

	@Query("SELECT z FROM Zerbitzuak z WHERE z.data.ezabatze_data IS NULL")
	List<Zerbitzuak> findByEzabatzeDataIsNull();

	@Query("SELECT z FROM Zerbitzuak z WHERE z.data.ezabatze_data IS NOT NULL")
	List<Zerbitzuak> findByEzabatzeDataIsNotNull();
}
