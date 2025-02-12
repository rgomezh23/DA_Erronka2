package eus.fpsanturtzilh.controllers;

import eus.fpsanturtzilh.models.Produktu_Mugimenduak;
import eus.fpsanturtzilh.services.ProduktuMugimenduakService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produktu-mugimenduak")
@CrossOrigin(origins = "http://localhost:8100")
public class ProduktuMugimenduakController {

    private final ProduktuMugimenduakService produktuMugimenduakService;

    public ProduktuMugimenduakController(ProduktuMugimenduakService produktuMugimenduakService) {
        this.produktuMugimenduakService = produktuMugimenduakService;
    }

    @GetMapping("/aktiboak")
    public ResponseEntity<List<Produktu_Mugimenduak>> getProduktuMugimenduAktiboak() {
        List<Produktu_Mugimenduak> mugimenduak = produktuMugimenduakService.findAllNotDeleted();
        return ResponseEntity.ok(mugimenduak);
    }

    @GetMapping("/ezabatuta")
    public ResponseEntity<List<Produktu_Mugimenduak>> getProduktuMugimenduEzabatuta() {
        List<Produktu_Mugimenduak> mugimenduak = produktuMugimenduakService.findAllDeleted();
        return ResponseEntity.ok(mugimenduak);
    }

    @PutMapping(value = "/eguneratu", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updateProduktuMugimendu(@RequestBody Produktu_Mugimenduak mugimendu) {
        try {
            Produktu_Mugimenduak eguneratua = produktuMugimenduakService.updateProduktuMugimendu(mugimendu);
            return ResponseEntity.ok(eguneratua);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Eguneratze datuak okerrak dira.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errorea eguneratzerakoan.");
        }
    }

    @DeleteMapping(value = "/ezabatu/{id}", produces = "application/json")
    public ResponseEntity<?> softDeleteProduktuMugimendu(@PathVariable int id) {
        try {
            produktuMugimenduakService.softDeleteProduktuMugimendu(id);
            return ResponseEntity.ok("Produktu mugimendua ezabatuta: " + id);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ez da aurkitu.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errorea ezabatzerakoan.");
        }
    }

    @DeleteMapping(value = "/hard/{id}", produces = "application/json")
    public ResponseEntity<?> hardDeleteProduktuMugimendu(@PathVariable int id) {
        try {
            produktuMugimenduakService.hardDeleteProduktuMugimendu(id);
            return ResponseEntity.ok("Produktu mugimendua guztiz ezabatuta: " + id);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ez da aurkitu.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errorea ezabatzerakoan.");
        }
    }

    @PostMapping(value = "/sortu", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> createProduktuMugimendu(@RequestBody Produktu_Mugimenduak mugimendu) {
		try {
			Produktu_Mugimenduak berria = produktuMugimenduakService.createNewProduktuMugimendu(mugimendu);
            return ResponseEntity.ok(berria);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Formatu txarra.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Zerbitzariaren errorea.");
        }
    }
}
