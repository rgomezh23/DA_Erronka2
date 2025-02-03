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

    @CrossOrigin(origins = "http://localhost:8100")
    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Zerbitzuak> updateProduktu(@RequestBody Zerbitzuak zerbitzua) {
        try {
            Zerbitzuak updatedProduct = zerbitzuService.updateZerbitzuak(zerbitzua);
            return ResponseEntity.ok(updatedProduct);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @CrossOrigin(origins = "http://localhost:8100") // Permitir CORS desde el cliente Ionic
    @PostMapping(value = "/save", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Zerbitzuak> saveServicio(@RequestBody Zerbitzuak zerbitzuak) {
        try {
            Zerbitzuak newServicio = zerbitzuService.saveZerbitzuak(zerbitzuak);
            return ResponseEntity.status(HttpStatus.CREATED).body(newServicio); // Retornar el nuevo servicio creado
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Nuevo endpoint para eliminar un servicio
    @CrossOrigin(origins = "http://localhost:8100")
    @DeleteMapping(value = "/delete/{id}", produces = "application/json")
    public ResponseEntity<Void> deleteServicio(@PathVariable int id) {
        try {
            boolean isDeleted = zerbitzuService.deleteZerbitzuak(id);
            if (isDeleted) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204 No Content
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
