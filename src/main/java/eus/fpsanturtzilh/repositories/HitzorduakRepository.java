package eus.fpsanturtzilh.repositories;

import java.time.LocalDate;
import java.util.Date; // Borrar.
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import eus.fpsanturtzilh.models.Hitzorduak;

@Repository
public interface HitzorduakRepository extends JpaRepository<Hitzorduak, Integer> {

	@Query("SELECT h FROM Hitzorduak h WHERE h.dataSimple.ezabatze_data IS NULL")
	List<Hitzorduak> findActiveAppointments();

	@Query("SELECT h FROM Hitzorduak h WHERE h.data = CAST(:date AS date)")
	List<Hitzorduak> findBySortzeData(@Param("date") LocalDate date);


	List<Hitzorduak> findByIzenaContainingIgnoreCase(String izena);

	List<Hitzorduak> findByEtxekoa(char etxekoa);

	@Query("SELECT h FROM Hitzorduak h WHERE h.dataSimple.sortze_data BETWEEN :startDate AND :endDate")
	List<Hitzorduak> findBySortzeDataBetween(LocalDate startDate, LocalDate endDate);
}