package eus.fpsanturtzilh.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eus.fpsanturtzilh.models.Hitzorduak;
import eus.fpsanturtzilh.services.HitzorduakService;

@RestController
@RequestMapping("/hitzorduak")
public class HitzorduakController {

    @Autowired
    private HitzorduakService hitzorduakService;

    // Permitir CORS desde el cliente Ionic (localhost:8100)
    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping("/hitzorduakGuztiak")
    public List<Hitzorduak> getHitzorduak() {
        return hitzorduakService.getAllHitzorduak();
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json") // Para actualizar.
    public ResponseEntity<Hitzorduak> updateHitzorduak(@RequestBody Hitzorduak hitzorduak) {
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
        try {
            // Llamamos al servicio para guardar la cita
            Hitzorduak createdHitzorduak = hitzorduakService.saveHitzorduak(hitzorduak);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdHitzorduak);
        } catch (Exception e) {
            // Captura la excepción y devuelve el mensaje de error
            String errorMessage = e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al insertar la cita: " + errorMessage);
        }
    }


    // Endpoint adicional para obtener citas activas
    @GetMapping("/activeAppointments")
    public List<Hitzorduak> getActiveAppointments() {
        return hitzorduakService.getActiveAppointments();
    }

    // Endpoint adicional para buscar citas por fecha
    @GetMapping("/appointmentsByDate")
    public List<Hitzorduak> getAppointmentsByDate(@RequestParam Date date) {
        return hitzorduakService.getAppointmentsByDate(date);
    }
}
