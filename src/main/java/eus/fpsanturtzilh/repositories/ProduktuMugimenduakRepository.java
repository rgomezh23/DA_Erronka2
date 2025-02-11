package eus.fpsanturtzilh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import eus.fpsanturtzilh.models.Produktu_Mugimenduak;
import java.util.List;

@Repository
public interface ProduktuMugimenduakRepository extends JpaRepository<Produktu_Mugimenduak, Integer> {

	@Query("SELECT p FROM Produktu_Mugimenduak p WHERE p.data.ezabatze_data IS NULL")
	List<Produktu_Mugimenduak> findAllActive();

	@Query("SELECT p FROM Produktu_Mugimenduak p WHERE p.data.ezabatze_data IS NOT NULL")
	List<Produktu_Mugimenduak> findAllDeleted();
}
