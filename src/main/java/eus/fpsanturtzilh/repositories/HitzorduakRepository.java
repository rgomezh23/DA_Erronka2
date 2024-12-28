package eus.fpsanturtzilh.repositories;

import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import eus.fpsanturtzilh.models.Hitzorduak;

@Repository
public interface HitzorduakRepository extends JpaRepository<Hitzorduak, Integer> {

	@Query("SELECT h FROM Hitzorduak h WHERE h.dataSimple.ezabatze_data IS NULL")
	List<Hitzorduak> findActiveAppointments();

	@Query("SELECT h FROM Hitzorduak h WHERE h.dataSimple.sortze_data = :data")
	List<Hitzorduak> findBySortzeData(Date data);

	List<Hitzorduak> findByIzenaContainingIgnoreCase(String izena);

	List<Hitzorduak> findByEtxekoa(char etxekoa);

	@Query("SELECT h FROM Hitzorduak h WHERE h.dataSimple.sortze_data BETWEEN :startDate AND :endDate")
	List<Hitzorduak> findBySortzeDataBetween(Date startDate, Date endDate);
}

// Todo esto es ignorable pero lo dejaré hasta que sepa que lo puedo borrar 100%.