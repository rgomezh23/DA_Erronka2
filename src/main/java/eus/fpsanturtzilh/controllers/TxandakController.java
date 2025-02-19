package eus.fpsanturtzilh.controllers;

import eus.fpsanturtzilh.models.Txandak;
import eus.fpsanturtzilh.services.TxandakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/txandak")
public class TxandakController {

	private final TxandakService txandakService;

	@Autowired
	public TxandakController(TxandakService txandakService) {
		this.txandakService = txandakService;
	}

	@GetMapping("/aktiboak")
	public ResponseEntity<List<Txandak>> getTxandakAktiboak() {
		List<Txandak> txandak = txandakService.findByDataEzabatzeDataIsNull();
		return ResponseEntity.ok(txandak);
	}

	@GetMapping("/ezabatuta")
	public ResponseEntity<List<Txandak>> getTxandakEzabatuta() {
		List<Txandak> txandak = txandakService.findByDataEzabatzeDataIsNotNull();
		return ResponseEntity.ok(txandak);
	}

	// Crear un nuevo txandak
	@CrossOrigin(origins = "http://localhost:8100")
	@PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> createTxandak(@RequestBody Txandak txandak) {
		try {
			Txandak txandakBerria = txandakService.createTxandak(txandak);
			return ResponseEntity.ok(txandakBerria);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Formatu txarra.");
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Zerbitzariaren errorea.");
		}
	}

	// Actualizar un txandak
	@CrossOrigin(origins = "http://localhost:8100")
	@PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> updateTxandak(@RequestBody Txandak txandak) {
		try {
			Txandak txandakBerria = txandakService.updateTxandak(txandak);
			return ResponseEntity.ok(txandakBerria);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errorea eguneratzerakoan.");
		}
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@DeleteMapping(value = "/softDelete/{id}", produces = "application/json")
	public ResponseEntity<?> softDeleteTxandak(@PathVariable int id) {
		try {
			Txandak txandakEzabatua = txandakService.softDeleteTxandakById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Txandak soft ezabatuta: " + txandakEzabatua.getId());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Errorea soft ezabatzerakoan: " + e.getMessage());
		}
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@DeleteMapping(value = "/hardDelete/{id}", produces = "application/json")
	public ResponseEntity<?> hardDeleteTxandak(@PathVariable int id) {
		try {
			txandakService.hardDeleteTxandakById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Txandak hard ezabatuta: " + id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Errorea hard ezabatzerakoan: " + e.getMessage());
		}
	}

}
