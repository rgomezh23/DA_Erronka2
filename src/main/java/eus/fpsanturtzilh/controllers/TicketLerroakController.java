package eus.fpsanturtzilh.controllers;

import eus.fpsanturtzilh.models.Ticket_lerroak;
import eus.fpsanturtzilh.services.TicketLerroakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket_lerroak")
public class TicketLerroakController {

	@Autowired
	private TicketLerroakService ticketLerroakService;

	@GetMapping("/aktiboak")
	public ResponseEntity<?> getTicketsWithEzabatzeDataNotNull() {
		List<Ticket_lerroak> tickets = ticketLerroakService.getTicketsWithEzabatzeDataNotNull();
		if (tickets.isEmpty()) {
			return new ResponseEntity<>("No tickets found with non-null 'ezabatze_data'.", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(tickets, HttpStatus.OK);
	}

	@GetMapping("/ezabatuta")
	public ResponseEntity<?> getTicketsWithEzabatzeDataNull() {
		List<Ticket_lerroak> tickets = ticketLerroakService.getTicketsWithEzabatzeDataNull();
		if (tickets.isEmpty()) {
			return new ResponseEntity<>("No tickets found with null 'ezabatze_data'.", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(tickets, HttpStatus.OK);
	}

	@PostMapping("/update")
	public ResponseEntity<?> updateTicket(@PathVariable int id) {
		Ticket_lerroak updatedTicket = ticketLerroakService.updateTicket(id);
		if (updatedTicket != null) {
			return new ResponseEntity<>("Ticket updated successfully with the current 'eguneratze_data'.",
					HttpStatus.OK);
		}
		return new ResponseEntity<>("Ticket not found.", HttpStatus.NOT_FOUND);
	}

	@PutMapping("/create")
	public ResponseEntity<?> insertTicket(@RequestBody Ticket_lerroak ticket) {
		Ticket_lerroak newTicket = ticketLerroakService.insertTicket(ticket);
		return new ResponseEntity<>("Ticket inserted successfully.", HttpStatus.CREATED);
	}

	@DeleteMapping("/soft/{id}")
	public ResponseEntity<?> softDeleteTicket(@PathVariable int id) {
		boolean isDeleted = ticketLerroakService.softDeleteTicket(id);
		if (isDeleted) {
			return new ResponseEntity<>("Ticket soft deleted successfully. 'ezabatze_data' updated.", HttpStatus.OK);
		}
		return new ResponseEntity<>("Ticket not found.", HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/hard/{id}")
	public ResponseEntity<?> hardDeleteTicket(@PathVariable int id) {
		boolean isDeleted = ticketLerroakService.hardDeleteTicket(id);
		if (isDeleted) {
			return new ResponseEntity<>("Ticket hard deleted successfully.", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>("Ticket not found.", HttpStatus.NOT_FOUND);
	}
}
