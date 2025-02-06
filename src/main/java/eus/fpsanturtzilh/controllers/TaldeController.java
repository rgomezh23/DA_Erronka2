package eus.fpsanturtzilh.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import eus.fpsanturtzilh.models.Taldeak;
import eus.fpsanturtzilh.services.TaldeService;

@RestController
@RequestMapping("/taldeak")
public class TaldeController {

	@Autowired
	private TaldeService taldeservice;

	@CrossOrigin(origins = "http://localhost:8100")
	@GetMapping("/talde")
	public ResponseEntity<List<Taldeak>> getTaldeak() {
		try {
			List<Taldeak> taldek = taldeservice.getAllNotDeleted();
			return ResponseEntity.ok(taldek);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@GetMapping("/ezabatutako-taldeak")
	public ResponseEntity<List<Taldeak>> getTaldeakEzabatuta() {
		try {
			List<Taldeak> taldek = taldeservice.getAllDeleted();
			return ResponseEntity.ok(taldek);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> updateTalde(@RequestBody Taldeak taldea) {
		try {
			Taldeak updatedTalde = taldeservice.updateTaldeak(taldea);
			return ResponseEntity.ok(updatedTalde);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Errorea taldea eguneratzerakoan.");
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore internoa");
		}
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@DeleteMapping(value = "/delete/{kodea}", produces = "application/json")
	public ResponseEntity<?> deleteTalde(@PathVariable("kodea") String kodea) {
		try {
			Taldeak deletedTalde = taldeservice.deleteTaldeaByKodea(kodea);
			if (deletedTalde != null) {
				return ResponseEntity.ok(deletedTalde);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Taldea ez da aurkitu.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Zerbitzariaren errorea.");
		}
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> createTalde(@RequestBody Taldeak taldea) {
		try {
			Taldeak newTalde = taldeservice.createNewTalde(taldea);
			return ResponseEntity.ok(newTalde);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Formatu txarra.");
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Zerbitzariaren errorea.");
		}
	}
}
