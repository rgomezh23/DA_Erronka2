package eus.fpsanturtzilh.controllers;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import eus.fpsanturtzilh.models.Bezero_fitxak;
import eus.fpsanturtzilh.services.BezeroFitxakService;

@RestController
@RequestMapping("/fitxak")
public class Bezero_fitxaController {

	@Autowired
	private BezeroFitxakService bezeroService;

	@GetMapping("/fitxakEzabatuta")
	public List<Bezero_fitxak> getFitxakEzabatuta() {
		List<Bezero_fitxak> allBezeroFitxak = bezeroService.getAllBezeroFitxak();
		return allBezeroFitxak.stream().filter(bezero -> bezero.getData().getEzabatze_data() != null)
				.collect(Collectors.toList());
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@GetMapping("/fitxakGuztiak")
	public ResponseEntity<?> getFitxak() {
		List<Bezero_fitxak> fitxak = bezeroService.getAllNotDeletedBezeroFitxak();
		if (fitxak.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ez dago fitxarik (ez dago fitxarik ez ezabatuta).");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(fitxak);
		}
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> updateFitxa(@RequestBody Bezero_fitxak bezero) {
	    try {
	        Bezero_fitxak bezeroBerria = bezeroService.updateBezero(bezero);
	        return ResponseEntity.status(HttpStatus.OK).body("Fitxa eguneratuta: " + bezeroBerria.getId());
	    } catch (Exception e) {
	        e.printStackTrace(); // Añadir esto para imprimir la traza del error
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Eguneratzean errorea gertatu da. " + e.getMessage());
	    }
	}


	@CrossOrigin(origins = "http://localhost:8100")
	@DeleteMapping(value = "/delete/{id}", produces = "application/json")
	public ResponseEntity<?> softDeleteFitxa(@PathVariable Integer id) {
		try {
			Bezero_fitxak bezeroBerria = bezeroService.softDeleteBezero(id);
			return ResponseEntity.status(HttpStatus.OK)
					.body("Fitxa '" + bezeroBerria.getId() + "' ezabatuta (soft delete).");
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ez da aurkitu id " + id + " ezabatzea egiteko.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errorea gertatu da fitxa ezabatzean.");
		}
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> createFitxa(@RequestBody Bezero_fitxak bezero) {
	    try {
	        Bezero_fitxak bezeroBerria = bezeroService.createNewBezero(bezero);

	        // Crear un mapa con la respuesta en formato JSON
	        Map<String, Object> response = new HashMap<>();
	        response.put("message", "Fitxa sortuta");
	        response.put("id", bezeroBerria.getId());

	        return ResponseEntity.status(HttpStatus.CREATED).body(response);
	    } catch (IllegalArgumentException e) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                .body(Collections.singletonMap("error", "Formatu txarra."));
	    } catch (RuntimeException e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body(Collections.singletonMap("error", "Zerbitzuaren errorea."));
	    }
	}


	@CrossOrigin(origins = "http://localhost:8100")
	@DeleteMapping(value = "trueDelete/{id}")
	public ResponseEntity<?> trueDeleteFitxa(@PathVariable Integer id) {
		try {
			bezeroService.trueDelete(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Ez da fitxa aurkitu.");
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Formatu txarra.");
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Zerbitzuaren errorea.");
		}
	}
}