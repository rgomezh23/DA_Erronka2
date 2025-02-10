package eus.fpsanturtzilh.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import eus.fpsanturtzilh.models.Hitzorduak;
import eus.fpsanturtzilh.services.HitzorduakService;

@RestController
@RequestMapping("/hitzorduak")
public class HitzorduakController {

    @Autowired
    private HitzorduakService hitzorduakService;

    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping("/hitzorduakGuztiak")
    public ResponseEntity<List<Hitzorduak>> getHitzorduak() {
        List<Hitzorduak> hitzorduakList = hitzorduakService.getAllHitzorduak();
        if (hitzorduakList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(hitzorduakList);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping("/ezabatuak")
    public ResponseEntity<List<Hitzorduak>> getDeletedHitzorduak() {
        List<Hitzorduak> deletedAppointments = hitzorduakService.getDeletedHitzorduak();
        if (deletedAppointments.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(deletedAppointments);
    }
    
    
    
    @CrossOrigin(origins = "http://localhost:8100")
    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updateHitzorduak(@RequestBody Hitzorduak hitzorduak) {
        if (hitzorduak == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Hitzordua eguneratu da!");
        }
        try {
            Hitzorduak updatedHitzorduak = hitzorduakService.updateHitzorduak(hitzorduak);
            return ResponseEntity.ok(updatedHitzorduak);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> createHitzorduak(@RequestBody Hitzorduak hitzorduak) {
        if (hitzorduak == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Hitzorduak formatu txarra dauka.");
        }
        try {
            Hitzorduak createdHitzorduak = hitzorduakService.saveHitzorduak(hitzorduak);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdHitzorduak);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping("/datarenHitzorduak")
    public ResponseEntity<List<Hitzorduak>> getAppointmentsByDate(@RequestParam LocalDate date) {
        List<Hitzorduak> appointments = hitzorduakService.getAppointmentsByDate(date);
        if (appointments.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(appointments);
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteHitzorduak(@PathVariable int id) {
        try {
            boolean deleted = hitzorduakService.deleteHitzorduak(id);
            if (deleted) {
                return ResponseEntity.ok("Hitzaordua ezabatu da.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ez da hitzordua aurkitu.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore bat egon da.");
        }
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @DeleteMapping("/hardDelete/{id}")
    public ResponseEntity<?> deleteHitzorduakPermanently(@PathVariable int id) {
        try {
            boolean deleted = hitzorduakService.deleteHitzorduakPermanently(id);
            if (deleted) {
                return ResponseEntity.ok("Hitzordua ezabatua izan da betiko.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hitzordua ez da aurkitu.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errorea hitzordua ezabatzean.");
        }
    }

}


/**
Resta  -1.

GET: http://localhost:8080/hitzorduak/hitzorduakGuztiak
GET: http://localhost:8080/hitzorduak/datarenHitzorduak?date=2025-02-10







Al insertar no resta 1.
POST: http://localhost:8080/hitzorduak/create
{
  "eserlekua": 5,
  "id_langilea": 1,
  "data": "2025-02-10",
  "hasiera_ordua": "10:00:00",
  "amaiera_ordua": "11:00:00",
  "hasiera_ordua_erreala": null,
  "amaiera_ordua_erreala": null,
  "izena": "Jon Doe",
  "telefonoa": "123456789",
  "deskribapena": "Revisión general",
  "etxekoa": "E",
  "prezio_totala": 50.00
}

Ni al Updatear:
PUT. http://localhost:8080/hitzorduak/update
{
  "id": 1443,
  "eserlekua": 3,
  "id_langilea": 1,
  "data": "2025-02-10",
  "hasiera_ordua": "09:30:00",
  "amaiera_ordua": "10:30:00",
  "hasiera_ordua_erreala": "09:35:00",
  "amaiera_ordua_erreala": "10:25:00",
  "izena": "Jane Doe",
  "telefonoa": "987654321",
  "deskribapena": "Consulta de seguimiento",
  "etxekoa": "K",
  "prezio_totala": 75.00
}


*/