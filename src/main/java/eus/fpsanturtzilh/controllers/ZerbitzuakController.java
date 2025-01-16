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

import eus.fpsanturtzilh.models.Zerbitzuak;
import eus.fpsanturtzilh.services.ZerbitzuakService;

@RestController
@RequestMapping("/zerbitzuak")
public class ZerbitzuakController {

    @Autowired
    private ZerbitzuakService zerbitzuService;

    // Permitir CORS desde el cliente Ionic (localhost:8100)
    @CrossOrigin(origins = "http://localhost:8100") 
    @GetMapping("/zerbitzuGuztiak")
    public List<Zerbitzuak> getZerbitzuak() {
        return zerbitzuService.getAllZerbitzuak();
    }

    @CrossOrigin(origins = "http://localhost:8100")  // Permitir CORS desde el cliente Ionic
    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Zerbitzuak> updateProduktu(@RequestBody Zerbitzuak zerbitzua) {
        try {
        	Zerbitzuak updatedProduct = zerbitzuService.updateZerbitzuak(zerbitzua);
            return ResponseEntity.ok(updatedProduct);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
