package eus.fpsanturtzilh.controllers;

import java.util.List;
import java.util.stream.Collectors;

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

import eus.fpsanturtzilh.models.Taldeak;
import eus.fpsanturtzilh.services.TaldeService;

@RestController
@RequestMapping("/taldeak")
public class TaldeController {

    @Autowired
    private TaldeService taldeservice;

    // Permitir CORS desde el cliente Ionic (localhost:8100)
    @CrossOrigin(origins = "http://localhost:8100") 
    @GetMapping("/talde")
    public List<Taldeak> getTaldeak() {
    	List<Taldeak> taldeak = taldeservice.getAllTaldeak();
        return taldeak.stream()
                .filter(taldea -> taldea.getData().getEzabatze_data() == null) 
                .collect(Collectors.toList());
    }
    
    @CrossOrigin(origins = "http://localhost:8100") 
    @GetMapping("/EzabatuLangile")
    public List<Taldeak> getTaldeakEzabatuta() {
        List<Taldeak> taldeak = taldeservice.getAllTaldeak();
        return taldeak.stream()
                .filter(taldea -> taldea.getData().getEzabatze_data() != null) 
                .collect(Collectors.toList());
    }

    @CrossOrigin(origins = "http://localhost:8100")  // Permitir CORS desde el cliente Ionic
    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Taldeak> updateTaldek(@RequestBody Taldeak talde) {
        try {
        	Taldeak taldeBerria = taldeservice.updateTaldeak(talde);
            return ResponseEntity.ok(taldeBerria);
        } catch (IllegalArgumentException e) {
      	  e.printStackTrace(); 
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
      } catch (RuntimeException e) {
      	  e.printStackTrace(); 
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
      }
    }
    
    @CrossOrigin(origins = "http://localhost:8100")  // Permitir CORS desde el cliente Ionic
    @PutMapping(value = "/delete", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Taldeak> deleteTalde(@RequestBody Taldeak talde) {
        try {
        	Taldeak bezeroBerria = taldeservice.deleteTaldea(talde);
            return ResponseEntity.ok(bezeroBerria);
        } catch (IllegalArgumentException e) {
            e.printStackTrace(); 
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        } catch (Exception e) {
        	e.printStackTrace(); 
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @CrossOrigin(origins = "http://localhost:8100")  // Permitir CORS desde el cliente Ionic
    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Taldeak> createTalde(@RequestBody Taldeak talde) {
        try {
        	Taldeak bezeroBerria = taldeservice.createNewTalde(talde); 
            return ResponseEntity.ok(bezeroBerria);
        } catch (IllegalArgumentException e) {
        	  e.printStackTrace(); 
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (RuntimeException e) {
        	  e.printStackTrace(); 
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
