package eus.fpsanturtzilh.controllers;

import eus.fpsanturtzilh.models.Langileak;
import eus.fpsanturtzilh.services.LangileakService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/langileak")
public class LangileakController {
	@Autowired
	private final LangileakService langileakService;

	public LangileakController(LangileakService langileakService) {
		this.langileakService = langileakService;
	}

	@GetMapping
	public ResponseEntity<List<Langileak>> getAllLangileak() {
		List<Langileak> langileakList = langileakService.findAll();
		return ResponseEntity.ok(langileakList);
	}

	@GetMapping("/trueLangileak")
	public List<Langileak> getLangileEzabatuta() {
		List<Langileak> langileak = langileakService.findAll();
		return langileak.stream().filter(langile -> langile.getData().getEzabatze_data() == null)
				.collect(Collectors.toList());
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> updateLangile(@RequestBody Langileak langile) {
		try {
			Langileak langileBerria = langileakService.updateLangile(langile);
			return ResponseEntity.ok(langileBerria);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errorea eguneratzerakoan.");
		}
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@PutMapping(value = "/delete", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> deleteLangile(@RequestBody Langileak langile) {
		try {
			Langileak langileBerria = langileakService.updateLangile(langile);
			return ResponseEntity.ok(langileBerria);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errorea ezabatzerakoan.");
		}
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> createLangile(@RequestBody Langileak langile) {
		try {
			Langileak langileBerria = langileakService.createNewLangile(langile);
			return ResponseEntity.ok(langileBerria);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Formatu txarra.");
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Zerbitzariaren errorea.");
		}
	}
}
