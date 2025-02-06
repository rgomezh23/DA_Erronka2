package eus.fpsanturtzilh.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.models.Produktuak;
import eus.fpsanturtzilh.repositories.ProduktuRepository;

@Service
public class ProduktuService {

    @Autowired
    private ProduktuRepository produktuRepository;

    public List<Produktuak> getAllProduktuak() {
        return produktuRepository.findAll();
    }

    public Produktuak getProduktuById(int id) {
        Optional<Produktuak> produktuakOpt = produktuRepository.findById(id);
        if (produktuakOpt.isPresent()) {
            return produktuakOpt.get();
        } else {
            throw new RuntimeException("Produktu ez da aurkitu ID-rekin: " + id);
        }
    }

    public Produktuak saveProduktu(Produktuak produktuak) {
        return produktuRepository.save(produktuak);
    }

    public Produktuak updateProduktu(Produktuak produktuak) {
        Optional<Produktuak> existingProductOpt = produktuRepository.findById(produktuak.getId());
        if (existingProductOpt.isPresent()) {
            Produktuak existingProduct = existingProductOpt.get();
            existingProduct.setIzena(produktuak.getIzena());
            existingProduct.setDeskribapena(produktuak.getDeskribapena());
            existingProduct.setMarka(produktuak.getMarka());
            existingProduct.setStock(produktuak.getStock());
            existingProduct.setStock_alerta(produktuak.getStock_alerta());

            if (produktuak.getKategoriak() != null) {
                existingProduct.setKategoriak(produktuak.getKategoriak());
            }

            if (produktuak.getData() != null) {
                existingProduct.setData(produktuak.getData());
            }

            return produktuRepository.save(existingProduct);
        } else {
            throw new RuntimeException("Produktu ez da aurkitu ID-rekin: " + produktuak.getId());
        }
    }

    public boolean deleteProduktu(int id) {
        Optional<Produktuak> productOpt = produktuRepository.findById(id);
        if (productOpt.isPresent()) {
            Produktuak produktuak = productOpt.get();
            // Establecer la fecha de eliminación (soft delete)
            produktuak.getData().setEzabatze_data(new Date(System.currentTimeMillis()));
            produktuRepository.save(produktuak);  // Guardamos los cambios
            return true;
        }
        return false;
    }

    public boolean hardDeleteProduktu(int id) {
        Optional<Produktuak> productOpt = produktuRepository.findById(id);
        if (productOpt.isPresent()) {
            produktuRepository.deleteById(id);  // Eliminación definitiva
            return true;
        }
        return false;
    }

    // Método para obtener los productos que no tienen fecha de eliminación (soft delete)
    public List<Produktuak> getProduktuakNotDeleted() {
        return produktuRepository.findAllNotDeleted(); // Filtra los productos donde ezabatze_data es NULL
    }

    // Método para obtener los productos que tienen fecha de eliminación (soft delete)
    public List<Produktuak> getProduktuakDeleted() {
        return produktuRepository.findAllDeleted(); // Filtra los productos donde ezabatze_data no es NULL
    }
}
