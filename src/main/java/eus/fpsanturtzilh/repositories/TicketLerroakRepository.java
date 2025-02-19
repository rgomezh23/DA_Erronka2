package eus.fpsanturtzilh.repositories;

import eus.fpsanturtzilh.models.Ticket_lerroak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface TicketLerroakRepository extends JpaRepository<Ticket_lerroak, Integer> {

	@Query("SELECT t FROM Ticket_lerroak t WHERE t.data.ezabatze_data IS NULL")
	List<Ticket_lerroak> findAllNotDeleted();

	@Query("SELECT t FROM Ticket_lerroak t WHERE t.data.ezabatze_data IS NOT NULL")
	List<Ticket_lerroak> findAllDeleted();
}
