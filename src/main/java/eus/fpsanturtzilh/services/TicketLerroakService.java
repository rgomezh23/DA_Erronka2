package eus.fpsanturtzilh.services;

import eus.fpsanturtzilh.models.Data;
import eus.fpsanturtzilh.models.Ticket_lerroak;
import eus.fpsanturtzilh.repositories.TicketLerroakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TicketLerroakService {

	@Autowired
	private TicketLerroakRepository ticketLerroakRepository;

	public List<Ticket_lerroak> getTicketsWithEzabatzeDataNotNull() {
		return ticketLerroakRepository.findAllNotDeleted();
	}

	public List<Ticket_lerroak> getTicketsWithEzabatzeDataNull() {
		return ticketLerroakRepository.findAllDeleted();
	}

	public Ticket_lerroak updateTicket(int id, Ticket_lerroak ticketActualizado) {
		Optional<Ticket_lerroak> optionalTicket = ticketLerroakRepository.findById(id);
		if (optionalTicket.isPresent()) {
			Ticket_lerroak ticket = optionalTicket.get();
			ticket.setZerbitzuak(ticketActualizado.getZerbitzuak());
			ticket.setHitzorduak(ticketActualizado.getHitzorduak());
			if (ticket.getData() == null) {
				ticket.setData(new Data());
			}

			if (ticketActualizado.getData().getSortze_data() != null) {
				ticket.getData().setSortze_data(ticketActualizado.getData().getSortze_data());
			}
			if (ticketActualizado.getData().getEguneratze_data() != null) {
				ticket.getData().setEguneratze_data(ticketActualizado.getData().getEguneratze_data());
			} else {
				ticket.getData().setEguneratze_data(ticket.getData().getEguneratze_data());
			}
			if (ticketActualizado.getData().getEzabatze_data() != null) {
				ticket.getData().setEzabatze_data(ticketActualizado.getData().getEzabatze_data());
			}

			ticket.setPrezioa(ticketActualizado.getPrezioa());
			return ticketLerroakRepository.save(ticket);
		}
		return null;
	}

	public Ticket_lerroak insertTicket(Ticket_lerroak ticket) {
		return ticketLerroakRepository.save(ticket);
	}

	public boolean softDeleteTicket(int id) {
		Optional<Ticket_lerroak> optionalTicket = ticketLerroakRepository.findById(id);
		if (optionalTicket.isPresent()) {
			Ticket_lerroak ticket = optionalTicket.get();
			java.sql.Date currentDate = java.sql.Date.valueOf(LocalDateTime.now().toLocalDate());
			ticket.getData().setEzabatze_data(currentDate);
			ticketLerroakRepository.save(ticket);
			return true;
		}
		return false;
	}

	public boolean hardDeleteTicket(int id) {
		Optional<Ticket_lerroak> optionalTicket = ticketLerroakRepository.findById(id);
		if (optionalTicket.isPresent()) {
			ticketLerroakRepository.delete(optionalTicket.get());
			return true;
		}
		return false;
	}
}
