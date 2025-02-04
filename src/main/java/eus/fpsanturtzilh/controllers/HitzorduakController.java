package eus.fpsanturtzilh.controllers;

import java.time.LocalDate;
// import java.sql.Date;
import java.util.Date; // Borrar.


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eus.fpsanturtzilh.models.Hitzorduak;
import eus.fpsanturtzilh.services.HitzorduakService;

@RestController
@RequestMapping("/hitzorduak")
public class HitzorduakController {

	@Autowired
	private HitzorduakService hitzorduakService;

	@CrossOrigin(origins = "http://localhost:8100")
	@GetMapping("/hitzorduakGuztiak")
	public ResponseEntity<List<Hitzorduak>> getHitzorduak() {
		List<Hitzorduak> hitzorduakList = hitzorduakService.getAllHitzorduak();
		if (hitzorduakList.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(hitzorduakList);
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Hitzorduak> updateHitzorduak(@RequestBody Hitzorduak hitzorduak) {
		try {
			if (hitzorduak == null) {
				throw new IllegalArgumentException("Hitzordua ezin da hutsik egon.");
			}
			Hitzorduak updatedHitzorduak = hitzorduakService.updateHitzorduak(hitzorduak);
			return ResponseEntity.ok(updatedHitzorduak);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> createHitzorduak(@RequestBody Hitzorduak hitzorduak) {
		System.out.println("Datos recibidos: " + hitzorduak);
		try {
			Hitzorduak createdHitzorduak = hitzorduakService.saveHitzorduak(hitzorduak);
			return ResponseEntity.status(HttpStatus.CREATED).body(createdHitzorduak);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
		}
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@GetMapping("/datarenHitzorduak")
	public ResponseEntity<List<Hitzorduak>> getAppointmentsByDate(@RequestParam LocalDate date) {
		List<Hitzorduak> appointments = hitzorduakService.getAppointmentsByDate(date);
		/**
		 * if (appointments.isEmpty()) { return ResponseEntity.noContent().build(); //
		 * Devuelve un 204 si no hay datos }
		 */
		System.out.println(appointments.getFirst().getData());
		return ResponseEntity.ok(appointments); // return ResponseEntity.notFound().build();
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteHitzorduak(@PathVariable int id) {
		try {
			boolean deleted = hitzorduakService.deleteHitzorduak(id);
			if (deleted) {
				return ResponseEntity.ok("Cita eliminada correctamente.");
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cita no encontrada.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar la cita.");
		}
	}
}

/**
Resta  -1.

GET: http://localhost:8080/hitzorduak/hitzorduakGuztiak
GET: http://localhost:8080/hitzorduak/datarenHitzorduak?date=2025-02-10







Al insertar no resta 1.
POST: http://localhost:8080/hitzorduak/create
{
  "eserlekua": 5,
  "id_langilea": 1,
  "data": "2025-02-10",
  "hasiera_ordua": "10:00:00",
  "amaiera_ordua": "11:00:00",
  "hasiera_ordua_erreala": null,
  "amaiera_ordua_erreala": null,
  "izena": "Jon Doe",
  "telefonoa": "123456789",
  "deskribapena": "Revisión general",
  "etxekoa": "E",
  "prezio_totala": 50.00
}

Ni al Updatear:
PUT. http://localhost:8080/hitzorduak/update
{
  "id": 1443,
  "eserlekua": 3,
  "id_langilea": 1,
  "data": "2025-02-10",
  "hasiera_ordua": "09:30:00",
  "amaiera_ordua": "10:30:00",
  "hasiera_ordua_erreala": "09:35:00",
  "amaiera_ordua_erreala": "10:25:00",
  "izena": "Jane Doe",
  "telefonoa": "987654321",
  "deskribapena": "Consulta de seguimiento",
  "etxekoa": "K",
  "prezio_totala": 75.00
}


*/