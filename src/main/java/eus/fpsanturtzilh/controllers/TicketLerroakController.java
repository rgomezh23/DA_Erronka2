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
			return new ResponseEntity<>("Ez daude ticket-ik.", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(tickets, HttpStatus.OK);
	}

	@GetMapping("/ezabatuta")
	public ResponseEntity<?> getTicketsWithEzabatzeDataNull() {
		List<Ticket_lerroak> tickets = ticketLerroakService.getTicketsWithEzabatzeDataNull();
		if (tickets.isEmpty()) {
			return new ResponseEntity<>("Ez dago ezer ezabatuta.", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(tickets, HttpStatus.OK);
	}

	// TIENE QUE TENER DATA SÍ O SÍ.
	@PutMapping("/update")
	public ResponseEntity<?> updateTicket(@RequestBody Ticket_lerroak ticket) {
		if (ticket.getId() == 0) {
			return new ResponseEntity<>("Ticket ID is required.", HttpStatus.BAD_REQUEST);
		}
		Ticket_lerroak updatedTicket = ticketLerroakService.updateTicket(ticket.getId(), ticket);
		if (updatedTicket != null) {
			return new ResponseEntity<>("Eguneratuta.", HttpStatus.OK);
		}
		return new ResponseEntity<>("Ez da aurkitu.", HttpStatus.NOT_FOUND);
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> createTicket(@RequestBody Ticket_lerroak ticket_lerroak) {
		if (ticket_lerroak == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ticket formatua ez da zuzena.");
		}
		try {
			Ticket_lerroak ticket_lerroak_sortua = ticketLerroakService.insertTicket(ticket_lerroak);
			return ResponseEntity.status(HttpStatus.CREATED).body(ticket_lerroak_sortua);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Errorea ticketa sortzerakoan: " + e.getMessage());
		}
	}

	@DeleteMapping("/soft/{id}")
	public ResponseEntity<?> softDeleteTicket(@PathVariable int id) {
		boolean isDeleted = ticketLerroakService.softDeleteTicket(id);
		if (isDeleted) {
			return new ResponseEntity<>("Ticket soft deleteatuta.", HttpStatus.OK);
		}
		return new ResponseEntity<>("Ticketa ez da aurkitu.", HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/hard/{id}")
	public ResponseEntity<?> hardDeleteTicket(@PathVariable int id) {
		boolean isDeleted = ticketLerroakService.hardDeleteTicket(id);
		if (isDeleted) {
			return new ResponseEntity<>("Ticket hard deleteatuta.", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>("Ticketa ez da aurkitu.", HttpStatus.NOT_FOUND);
	}
}
