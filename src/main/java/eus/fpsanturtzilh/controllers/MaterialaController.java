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

import eus.fpsanturtzilh.models.Materialak;
import eus.fpsanturtzilh.services.MaterialaService;


@RestController
@RequestMapping("/materialak")
public class MaterialaController {

    @Autowired
    private MaterialaService materialaService;

    @CrossOrigin(origins = "http://localhost:8100") 
    @GetMapping("/materialGuztiak")
    public List<Materialak> getMaterialak() {
        return materialaService.getAllMaterialak();
    }

    @CrossOrigin(origins = "http://localhost:8100")  
    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Materialak> updateProduktu(@RequestBody Materialak materiala) {
        try {
            Materialak eguneratuMateriala = materialaService.updateMateriala(materiala);
            return ResponseEntity.ok(eguneratuMateriala);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
