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
    public ResponseEntity<List<Hitzorduak>> getHitzorduak() {
        List<Hitzorduak> hitzorduakList = hitzorduakService.getAllHitzorduak();
        if (hitzorduakList.isEmpty()) {
            return ResponseEntity.noContent().build();  // Retorna 204 si no hay citas
        }
        return ResponseEntity.ok(hitzorduakList);  // Retorna la lista si está disponible
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
        System.out.println("Datos recibidos: " + hitzorduak);
        try {
            Hitzorduak createdHitzorduak = hitzorduakService.saveHitzorduak(hitzorduak);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdHitzorduak);
        } catch (Exception e) {
            e.printStackTrace();  // Imprime el error en los logs
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }
    
    // NUEVO:
    @PostMapping("/create")  // Asegúrate de que la ruta esté definida como "/create"
    public ResponseEntity<?> crearHitzordua(@RequestBody Hitzorduak hitzordua) {
        // Aquí va la lógica para insertar el objeto en la base de datos
        return ResponseEntity.ok("Hitzordua creado con éxito");
    }
 // NUEVO:
    
    
    

    // Esto no siempre funciona., y no sirve para nada.
    @GetMapping("/activeAppointments")
    public ResponseEntity<List<Hitzorduak>> getActiveAppointments() {
        List<Hitzorduak> activeAppointments = hitzorduakService.getActiveAppointments();
        return ResponseEntity.ok(activeAppointments);
    }

    // Esto busca las citas por fechas.
    @GetMapping("/appointmentsByDate")
    public ResponseEntity<List<Hitzorduak>> getAppointmentsByDate(@RequestParam Date date) { // O String.
        List<Hitzorduak> appointments = hitzorduakService.getAppointmentsByDate(date);
        return ResponseEntity.ok(appointments);
    }
}
