package eus.fpsanturtzilh.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import eus.fpsanturtzilh.models.Materialak;
import eus.fpsanturtzilh.services.MaterialaService;

@RestController
@RequestMapping("/materialak")
public class MaterialController {

	@Autowired
	private MaterialaService materialaService;

	@CrossOrigin(origins = "http://localhost:8100")
	@GetMapping("/materialGuztiak")
	public ResponseEntity<List<Materialak>> getMaterialak() {
		List<Materialak> materialakList = materialaService.getAllMaterialak();
		if (materialakList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.ok(materialakList);
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> createMateriala(@RequestBody Materialak materialak) {
		if (materialak == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El material tiene un formato incorrecto.");
		}
		try {
			Materialak createdMaterial = materialaService.createMateriala(materialak);
			return ResponseEntity.status(HttpStatus.CREATED).body(createdMaterial);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error al crear el material: " + e.getMessage());
		}
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@PutMapping(value = "/update/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> updateMateriala(@RequestBody Materialak materialak, @PathVariable Integer id) {
		if (materialak == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El material tiene un formato incorrecto.");
		}
		try {
			Materialak updatedMaterial = materialaService.updateMateriala(materialak);
			return ResponseEntity.ok(updatedMaterial);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error al actualizar el material: " + e.getMessage());
		}
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteMateriala(@PathVariable Integer id) {
		try {
			Optional<Materialak> existingMaterial = materialaService.getMaterialaById(id);
			if (existingMaterial.isPresent()) {
				materialaService.deleteMateriala(id);
				return ResponseEntity.ok("Material eliminado correctamente.");
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Material no encontrado.");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error al eliminar el material: " + e.getMessage());
		}
	}
}
