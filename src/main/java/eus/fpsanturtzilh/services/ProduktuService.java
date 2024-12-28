package eus.fpsanturtzilh.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.repositories.ProduktuRepository;
import eus.fpsanturtzilh.models.*;

@Service
public class ProduktuService {
    @Autowired
    private ProduktuRepository produktuRepository;

    public List<Produktuak> getAllProduktuak() {
        return produktuRepository.findAll();
    }
}
