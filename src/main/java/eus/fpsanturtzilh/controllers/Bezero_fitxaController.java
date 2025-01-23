package eus.fpsanturtzilh.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
        // Filtrar las entradas donde ezabatze_data no sea null
        List<Bezero_fitxak> allBezeroFitxak = bezeroService.getAllBezeroFitxak();
        return allBezeroFitxak.stream()
                .filter(bezero -> bezero.getData().getEzabatze_data() != null)  // Filtrar por la condición
                .collect(Collectors.toList());
    }
    
    @GetMapping("/fitxakGuztiak")
    public List<Bezero_fitxak> getFitxak() {
        // Filtrar las entradas donde ezabatze_data no sea null
        List<Bezero_fitxak> allBezeroFitxak = bezeroService.getAllBezeroFitxak();
        return allBezeroFitxak.stream()
                .filter(bezero -> bezero.getData().getEzabatze_data() == null)  
                .collect(Collectors.toList());
    }

    @CrossOrigin(origins = "http://localhost:8100")  // Permitir CORS desde el cliente Ionic
    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Bezero_fitxak> updateFitxa(@RequestBody Bezero_fitxak bezero) {
        try {
        	Bezero_fitxak bezeroBerria = bezeroService.updateBezero(bezero);
            return ResponseEntity.ok(bezeroBerria);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @PutMapping(value = "/delete", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Bezero_fitxak> deleteFitxa(@RequestBody Bezero_fitxak bezero) {
        try {
        	Bezero_fitxak bezeroBerria = bezeroService.updateBezero(bezero);
            return ResponseEntity.ok(bezeroBerria);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
