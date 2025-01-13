package eus.fpsanturtzilh.controllers;

import java.util.List;

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

    // Permitir CORS desde el cliente Ionic (localhost:8100)
    @CrossOrigin(origins = "http://localhost:8100") 
    @GetMapping("/fitxakGuztiak")
    public List<Bezero_fitxak> getFitxak() {
        return bezeroService.getAllBezeroFitxak();
    }

    @CrossOrigin(origins = "http://localhost:8100")  // Permitir CORS desde el cliente Ionic
    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Bezero_fitxak> updateProduktu(@RequestBody Bezero_fitxak bezero) {
        try {
        	Bezero_fitxak bezeroBerria = bezeroService.updateBezero(bezero);
            return ResponseEntity.ok(bezeroBerria);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
