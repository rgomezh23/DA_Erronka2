package eus.fpsanturtzilh.controllers;

import eus.fpsanturtzilh.models.Ordutegiak;
import eus.fpsanturtzilh.services.OrdutegiakService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ordutegiak")
public class OrdutegiakController {

	@Autowired
	private final OrdutegiakService ordutegiakService;

	public OrdutegiakController(OrdutegiakService ordutegiakService) {
		this.ordutegiakService = ordutegiakService;
	}

	@GetMapping("/aktiboak")
	public ResponseEntity<List<Ordutegiak>> getOrdutegiakAktiboak() {
		List<Ordutegiak> ordutegiak = ordutegiakService.findAllNotDeleted();
		return ResponseEntity.ok(ordutegiak);
	}

	@GetMapping("/ezabatuta")
	public ResponseEntity<List<Ordutegiak>> getOrdutegiakEzabatuta() {
		List<Ordutegiak> ordutegiak = ordutegiakService.findAllDeleted();
		return ResponseEntity.ok(ordutegiak);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getOrdutegiakById(@PathVariable int id) {
		Optional<Ordutegiak> ordutegiak = ordutegiakService.findById(id);
		if (ordutegiak.isPresent()) {
			return ResponseEntity.ok(ordutegiak.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ordutegia ez da aurkitu.");
		}
	}

	@PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> createOrdutegiak(@RequestBody Ordutegiak ordutegiak) {
		try {
			Ordutegiak createdOrdutegiak = ordutegiakService.createNewOrdutegiak(ordutegiak);
			return ResponseEntity.status(HttpStatus.CREATED).body(createdOrdutegiak);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Formatu txarra.");
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Zerbitzariaren errorea.");
		}
	}

	@PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> updateOrdutegiak(@RequestBody Ordutegiak ordutegiak) {
		try {
			Ordutegiak updatedOrdutegiak = ordutegiakService.updateOrdutegiak(ordutegiak);
			return ResponseEntity.ok(updatedOrdutegiak);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errorea eguneratzerakoan.");
		}
	}

	@DeleteMapping(value = "/delete/soft/{id}", produces = "application/json")
	public ResponseEntity<?> softDeleteOrdutegiak(@PathVariable int id) {
		try {
			Ordutegiak deletedOrdutegiak = ordutegiakService.softDelete(id);
			return ResponseEntity.status(HttpStatus.OK).body("Ordutegiak soft delete: " + deletedOrdutegiak.getId());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ezabatzerako errorea: " + e.getMessage());
		}
	}

	@DeleteMapping(value = "/delete/hard/{id}", produces = "application/json")
	public ResponseEntity<?> hardDeleteOrdutegiak(@PathVariable int id) {
		try {
			ordutegiakService.hardDelete(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Ordutegiaa hard delete.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ezin izan da hard delete.");
		}
	}
}
