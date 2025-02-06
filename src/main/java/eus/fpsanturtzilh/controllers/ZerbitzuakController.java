package eus.fpsanturtzilh.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import eus.fpsanturtzilh.models.Zerbitzuak;
import eus.fpsanturtzilh.services.ZerbitzuakService;

@RestController
@RequestMapping("/zerbitzuak")
public class ZerbitzuakController {

	@Autowired
	private ZerbitzuakService zerbitzuService;

	@CrossOrigin(origins = "http://localhost:8100")
	@GetMapping("/aktiboak")
	public ResponseEntity<List<Zerbitzuak>> getZerbitzuakEzabatzeDataNull() {
		try {
			List<Zerbitzuak> zerbitzuak = zerbitzuService.getZerbitzuakWithEzabatzeDataNull();
			return ResponseEntity.ok(zerbitzuak);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@GetMapping("/ez-aktiboak")
	public ResponseEntity<List<Zerbitzuak>> getZerbitzuakEzabatzeDataNotNull() {
		try {
			List<Zerbitzuak> zerbitzuak = zerbitzuService.getZerbitzuakWithEzabatzeDataNotNull();
			return ResponseEntity.ok(zerbitzuak);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@PostMapping(value = "/update", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Zerbitzuak> updateZerbitzuak(@RequestBody Zerbitzuak zerbitzua) {
		try {
			Zerbitzuak updatedZerbitzu = zerbitzuService.updateZerbitzuak(zerbitzua);
			return ResponseEntity.ok(updatedZerbitzu);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@PutMapping(value = "/insert", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Zerbitzuak> insertZerbitzuak(@RequestBody Zerbitzuak zerbitzua) {
		try {
			Zerbitzuak newZerbitzu = zerbitzuService.insertZerbitzuak(zerbitzua);
			return ResponseEntity.ok(newZerbitzu);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@DeleteMapping("/softDelete/{id}")
	public ResponseEntity<String> softDeleteZerbitzuak(@PathVariable int id) {
		try {
			boolean result = zerbitzuService.softDeleteZerbitzuak(id);
			if (result) {
				return ResponseEntity.ok("Zerbitzua ezabatuta");
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Zerbitzua ez da aurkitu");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore bat egon da.");
		}
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@DeleteMapping("/hardDelete/{id}")
	public ResponseEntity<String> hardDeleteZerbitzuak(@PathVariable int id) {
		try {
			boolean result = zerbitzuService.hardDeleteZerbitzuak(id);
			if (result) {
				return ResponseEntity.ok("Zerbitzua guztiz ezabatuta");
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Zerbitzua ez da aurkitu");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore bat egon da.");
		}
	}
}
