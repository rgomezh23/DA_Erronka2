package eus.fpsanturtzilh.controllers;

import eus.fpsanturtzilh.models.Langileak;
import eus.fpsanturtzilh.services.LangileakService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/langileak")
public class LangileakController {
    
    @Autowired
    private final LangileakService langileakService;

    public LangileakController(LangileakService langileakService) {
        this.langileakService = langileakService;
    }

    @GetMapping("/aktiboak")
    public ResponseEntity<List<Langileak>> getLangileAktiboak() {
        List<Langileak> langileak = langileakService.findAllNotDeleted();
        return ResponseEntity.ok(langileak);
    }

    @GetMapping("/ezabatuta")
    public ResponseEntity<List<Langileak>> getLangileEzabatuta() {
        List<Langileak> langileak = langileakService.findAllDeleted();
        return ResponseEntity.ok(langileak);
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
    @PutMapping(value = "/delete/{id}", produces = "application/json")
    public ResponseEntity<?> deleteLangile(@PathVariable int id) {
        try {
            Langileak langileEzabatua = langileakService.deleteLangileById(id);
            return ResponseEntity.ok(langileEzabatua);
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
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Formatu txarra.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Zerbitzariaren errorea.");
        }
    }
}
