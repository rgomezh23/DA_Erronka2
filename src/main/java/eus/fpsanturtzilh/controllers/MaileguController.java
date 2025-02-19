package eus.fpsanturtzilh.controllers;

import eus.fpsanturtzilh.models.Material_maileguak;
import eus.fpsanturtzilh.services.MaileguService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mailegu")
public class MaileguController {

    private final MaileguService maileguService;

    public MaileguController(MaileguService maileguService) {
        this.maileguService = maileguService;
    }

    @GetMapping("/maileguGuztiak")
    public ResponseEntity<List<Material_maileguak>> getMaterialAktiboak() {
        List<Material_maileguak> materials = maileguService.findAllNotDeleted();
        return ResponseEntity.ok(materials);
    }

    @GetMapping("/ezabatuta")
    public ResponseEntity<List<Material_maileguak>> getMaterialEzabatuta() {
        List<Material_maileguak> materials = maileguService.findAllDeleted();
        return ResponseEntity.ok(materials);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMaterialById(@PathVariable int id) {
        Optional<Material_maileguak> materialOptional = maileguService.findById(id);

        if (materialOptional.isPresent()) {
            return ResponseEntity.ok(materialOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Materiala ez dago ID-rekin: " + id);
        }
    }

	@PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> createMaterial(@RequestBody Material_maileguak materialMaileguak) {
        try {
            Material_maileguak savedMaterial = maileguService.createNewMaterial(materialMaileguak);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedMaterial);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Errorea: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Zerbitzariaren errorea.");
        }
    }

    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updateMaterial(@RequestBody Material_maileguak materialMaileguak) {
        try {
            Material_maileguak updatedMaterial = maileguService.updateMaterial(materialMaileguak);
            return ResponseEntity.ok(updatedMaterial);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Materiala ez dago ID-rekin: " + materialMaileguak.getId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errorea eguneratzerakoan.");
        }
    }

    @DeleteMapping("/soft-delete/{id}")
    public ResponseEntity<?> softDeleteMaterial(@PathVariable int id) {
        try {
            Material_maileguak material = maileguService.softDeleteMaterial(id);
            return ResponseEntity.status(HttpStatus.OK).body("Materiala ezabatuta: " + material.getId());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Materiala ez da aurkitu: " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errorea ezabatzerakoan.");
        }
    }

    @DeleteMapping("/hard-delete/{id}")
    public ResponseEntity<?> hardDeleteMaterial(@PathVariable int id) {
        try {
            maileguService.hardDeleteMaterial(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Materiala guztiz ezabatuta: " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errorea ezabatzerakoan.");
        }
    }
}
