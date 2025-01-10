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

import eus.fpsanturtzilh.models.Material_maileguak;
import eus.fpsanturtzilh.services.MaileguService;


@RestController
@RequestMapping("/maileguak")
public class MaileguController {

    @Autowired
    private MaileguService maileguServicce;

    @CrossOrigin(origins = "http://localhost:8100") 
    @GetMapping("/maileguGuztiak")
    public List<Material_maileguak> getMaileguak() {
        return maileguServicce.getAllMaileguak();
    }

    @CrossOrigin(origins = "http://localhost:8100")  // Permitir CORS desde el cliente Ionic
    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Material_maileguak> updateMaileguak(@RequestBody Material_maileguak mailegu) {
        try {
        	Material_maileguak maileguBerria = maileguServicce.updateMaileguak(mailegu);
            return ResponseEntity.ok(maileguBerria);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
