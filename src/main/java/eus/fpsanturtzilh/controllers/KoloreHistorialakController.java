package eus.fpsanturtzilh.controllers;

import eus.fpsanturtzilh.models.Kolore_historialak;
import eus.fpsanturtzilh.services.KoloreHistorialakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kolore-historialak")
public class KoloreHistorialakController {

	@Autowired
	private KoloreHistorialakService koloreHistorialakService;

	@CrossOrigin(origins = "http://localhost:8100")
	@GetMapping("/historial")
	public ResponseEntity<List<Kolore_historialak>> getKoloreHistorialak() {
		try {
			List<Kolore_historialak> historial = koloreHistorialakService.getAllNotDeleted();
			return ResponseEntity.ok(historial);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@GetMapping("/ezabatuta")
	public ResponseEntity<List<Kolore_historialak>> getKoloreHistorialakEzabatuta() {
		try {
			List<Kolore_historialak> historial = koloreHistorialakService.getAllDeleted();
			return ResponseEntity.ok(historial);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> updateKoloreHistorialak(@RequestBody Kolore_historialak koloreHistorialak) {
		try {
			Kolore_historialak updatedHistorial = koloreHistorialakService.updateKoloreHistorialak(koloreHistorialak);
			if (updatedHistorial != null) {
				return ResponseEntity.ok(updatedHistorial);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Historiala ez da aurkitu.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Errorea eguneratzean.");
		}
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@DeleteMapping(value = "/delete/{id}", produces = "application/json")
	public ResponseEntity<?> deleteKoloreHistorialak(@PathVariable("id") int id) {
		try {
			Kolore_historialak deletedHistorial = koloreHistorialakService.deleteKoloreHistorialakById(id);
			if (deletedHistorial != null) {
				return ResponseEntity.ok(deletedHistorial);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Historiala ez da aurkitu.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Zerbitzariaren errorea.");
		}
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> createKoloreHistorialak(@RequestBody Kolore_historialak koloreHistorialak) {
		try {
			Kolore_historialak newHistorial = koloreHistorialakService.createNewKoloreHistorialak(koloreHistorialak);
			return ResponseEntity.ok(newHistorial);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Errore bat gertatu da.");
		}
	}

	// Función de Hard Delete
	@CrossOrigin(origins = "http://localhost:8100")
	@DeleteMapping(value = "/hard-delete/{id}", produces = "application/json")
	public ResponseEntity<?> hardDeleteKoloreHistorialak(@PathVariable("id") int id) {
		try {
			boolean isDeleted = koloreHistorialakService.hardDeleteKoloreHistorialakById(id);
			if (isDeleted) {
				return ResponseEntity.ok("Historiala behar bezala ezabatuta.");
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Historiala ez da aurkitu.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore bat gertatu da.");
		}
	}
}
