package eus.fpsanturtzilh.controllers;

import eus.fpsanturtzilh.models.Langileak;
import eus.fpsanturtzilh.services.LangileakService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/langileak")
public class LangileakController {

    private final LangileakService langileakService;

    public LangileakController(LangileakService langileakService) {
        this.langileakService = langileakService;
    }

    /**
     * Endpoint para obtener todos los Langileak.
     * @return Respuesta HTTP con la lista de Langileak.
     */
    @GetMapping
    public ResponseEntity<List<Langileak>> getAllLangileak() {
        List<Langileak> langileakList = langileakService.findAll();
        return ResponseEntity.ok(langileakList);
    }
}
