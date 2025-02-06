package eus.fpsanturtzilh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import eus.fpsanturtzilh.models.Produktuak;
import eus.fpsanturtzilh.services.ProduktuService;

import java.util.List;

@RestController
@RequestMapping("/produktuak")
public class ProduktuController {

	@Autowired
	private ProduktuService produktuService;

	@CrossOrigin(origins = "http://localhost:8100")
	@GetMapping("/produktuGuztiak")
	public ResponseEntity<List<Produktuak>> getProduktuak() {
		List<Produktuak> produktuakList = produktuService.getAllProduktuak();
		if (produktuakList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.ok(produktuakList);
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@GetMapping("/{id}")
	public ResponseEntity<?> getProduktuById(@PathVariable int id) {
		try {
			Produktuak produktuak = produktuService.getProduktuById(id);
			return ResponseEntity.ok(produktuak);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produktu ez da aurkitu ID-rekin: " + id);
		}
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> createProduktu(@RequestBody Produktuak produktuak) {
		if (produktuak == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Produktuaren formatua okerra da.");
		}
		try {
			Produktuak createdProduct = produktuService.saveProduktu(produktuak);
			return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Errore bat gertatu da produktu bat sortzean.");
		}
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> updateProduktu(@RequestBody Produktuak produktuak) {
		if (produktuak == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Produktuaren formatua okerra da.");
		}
		try {
			Produktuak updatedProduct = produktuService.updateProduktu(produktuak);
			return ResponseEntity.ok(updatedProduct);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Errore bat gertatu da produktu bat eguneratzean.");
		}
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProduktu(@PathVariable int id) {
		try {
			boolean deleted = produktuService.deleteProduktu(id);
			if (deleted) {
				return ResponseEntity.ok("Produktu soft ezabatu da.");
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produktu ez da aurkitu ID-rekin: " + id);
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Errore bat gertatu da produktu bat ezabatzean.");
		}
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@DeleteMapping("/hard-delete/{id}")
	public ResponseEntity<?> hardDeleteProduktu(@PathVariable int id) {
		try {
			boolean deleted = produktuService.hardDeleteProduktu(id);
			if (deleted) {
				return ResponseEntity.ok("Produktu fisikoki ezabatu da.");
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produktu ez da aurkitu ID-rekin: " + id);
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Errore bat gertatu da produktu bat ezabatzean.");
		}
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@GetMapping("/aktiboak")
	public ResponseEntity<List<Produktuak>> getProduktuakNotDeleted() {
		List<Produktuak> produktuakList = produktuService.getProduktuakNotDeleted();
		if (produktuakList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.ok(produktuakList);
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@GetMapping("/ezabatuta")
	public ResponseEntity<List<Produktuak>> getProduktuakDeleted() {
		List<Produktuak> produktuakList = produktuService.getProduktuakDeleted();
		if (produktuakList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.ok(produktuakList);
	}
}