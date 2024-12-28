package eus.fpsanturtzilh.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eus.fpsanturtzilh.models.Produktuak;
import eus.fpsanturtzilh.services.ProduktuService;

@RestController
@RequestMapping("/produktuak")
public class ProduktuController {

    @Autowired
    private ProduktuService produktuService;

    @CrossOrigin(origins = "http://localhost:8100") 
    @GetMapping("/produktuGuztiak")
    public List<Produktuak> getProduktuak() {
        return produktuService.getAllProduktuak();
    }
}
