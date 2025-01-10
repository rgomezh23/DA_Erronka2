package eus.fpsanturtzilh.repositories;

import eus.fpsanturtzilh.models.Ticket_lerroak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketLerroakRepository extends JpaRepository<Ticket_lerroak, Integer> {
}
