package eus.fpsanturtzilh.controllers;

import java.util.List;

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
        return allBezeroFitxak.stream()
                .filter(bezero -> bezero.getData().getEzabatze_data() != null)  
                .collect(Collectors.toList());
    }
    
    @GetMapping("/fitxakGuztiak")
    public ResponseEntity<?> getFitxak() {
        List<Bezero_fitxak> fitxak = bezeroService.getAllNotDeletedBezeroFitxak();
        return fitxak.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ez dago fitxarik.") : ResponseEntity.ok(fitxak);
    }

    @CrossOrigin(origins = "http://localhost:8100") 
    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updateFitxa(@RequestBody Bezero_fitxak bezero) {
        try {
            Bezero_fitxak bezeroBerria = bezeroService.updateBezero(bezero);
            return ResponseEntity.ok("Fitxa eguneratuta: " + bezeroBerria.getId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Eguneratzean errorea gertatu da.");
        }
    }
    
    @CrossOrigin(origins = "http://localhost:8100")  
    @PutMapping(value = "/delete", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> deleteFitxa(@RequestBody Bezero_fitxak bezero) {
        try {
            Bezero_fitxak bezeroBerria = bezeroService.deleteBezero(bezero);
            return ResponseEntity.ok("Fitxa ezabatuta: " + bezeroBerria.getId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ezabatzean errorea gertatu da.");
        }
    }
    
    @CrossOrigin(origins = "http://localhost:8100") 
    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> createFitxa(@RequestBody Bezero_fitxak bezero) {
        try {
            Bezero_fitxak bezeroBerria = bezeroService.createNewBezero(bezero);
            return ResponseEntity.status(HttpStatus.CREATED).body("Fitxa sortuta: " + bezeroBerria.getId());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    
    @CrossOrigin(origins = "http://localhost:8100") 
    @DeleteMapping(value = "trueDelete/{id}")  
    public ResponseEntity<Void> trueDeleteFitxa(@PathVariable Integer id) {
        try {
            bezeroService.trueDelete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  // Código 204 (No Content)
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}