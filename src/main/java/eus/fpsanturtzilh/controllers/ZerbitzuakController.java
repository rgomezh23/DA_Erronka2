package eus.fpsanturtzilh.controllers;

import java.util.List;
import java.util.Optional;

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
	@GetMapping("/{id}")
	public ResponseEntity<?> getZerbitzuaById(@PathVariable int id) {
		try {
			Optional<Zerbitzuak> zerbitzua = zerbitzuService.getZerbitzuaById(id);
			return zerbitzua.map(ResponseEntity::ok)
					.orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Zerbitzari errorea.");
		}
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@PostMapping(value = "/insert", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> updateZerbitzuak(@RequestBody Zerbitzuak zerbitzua) {
		try {
			Zerbitzuak updatedZerbitzu = zerbitzuService.insertZerbitzuak(zerbitzua);
			return ResponseEntity.ok(updatedZerbitzu);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ezin izan da zerbitzua txertatu.");
		}
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> insertZerbitzuak(@RequestBody Zerbitzuak zerbitzua) {
		try {
			Zerbitzuak newZerbitzu = zerbitzuService.updateZerbitzuak(zerbitzua);
			return ResponseEntity.ok(newZerbitzu);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errorea eguneratzerakoan.");
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
