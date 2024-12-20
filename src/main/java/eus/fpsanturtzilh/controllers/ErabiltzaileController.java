package eus.fpsanturtzilh.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eus.fpsanturtzilh.models.Erabiltzaile;
import eus.fpsanturtzilh.services.ErabiltzaileService;

@RestController
@RequestMapping("/erabiltzaileak")
public class ErabiltzaileController {

    @Autowired
    private ErabiltzaileService erabiltzaileService;

    @GetMapping("/{username}")
    public Optional<Erabiltzaile> getErabiltzaile(@PathVariable String username) {
        return erabiltzaileService.getErabiltzaileByUsername(username);
    }

    @GetMapping("/a")
    public String a() {
        return "Funciona!!!!!";
    }
}


