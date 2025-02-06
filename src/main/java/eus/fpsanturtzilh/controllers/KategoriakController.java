package eus.fpsanturtzilh.controllers;

import java.util.List;
import java.util.stream.Collectors;

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
import org.springframework.web.bind.annotation.RestController;

import eus.fpsanturtzilh.models.Kategoriak;
import eus.fpsanturtzilh.services.KategoriakService;

@RestController
@RequestMapping("/kategoriak")
public class KategoriakController {

	@Autowired
	private KategoriakService kategoriaService;

	@GetMapping("/kategoriakEzabatuta")
	public List<Kategoriak> getFitxakEzabatuta() {
		List<Kategoriak> allBezeroFitxak = kategoriaService.getAllBezeroFitxak();
		return allBezeroFitxak.stream().filter(bezero -> bezero.getData().getEzabatze_data() != null)
				.collect(Collectors.toList());
	}

	@GetMapping("/kategoriakGuztiak")
	public List<Kategoriak> getFitxak() {
		List<Kategoriak> allBezeroFitxak = kategoriaService.getAllBezeroFitxak();
		return allBezeroFitxak.stream().filter(bezero -> bezero.getData().getEzabatze_data() == null)
				.collect(Collectors.toList());
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> updateFitxa(@RequestBody Kategoriak kategoria) {
		try {
			Kategoriak kategoriaBerria = kategoriaService.updateKategoria(kategoria);
			return ResponseEntity.ok(kategoriaBerria);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Zerbitzariaren errorea.");
		}
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> createKategoria(@RequestBody Kategoriak bezero) {
		try {
			Kategoriak kategoriaBerria = kategoriaService.createNewKategoria(bezero);
			return ResponseEntity.ok(kategoriaBerria);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@DeleteMapping(value = "trueDelete/{id}")
	public ResponseEntity<?> trueDeleteKategoria(@PathVariable Integer id) {
		try {
			kategoriaService.trueDelete(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
