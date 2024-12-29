package eus.fpsanturtzilh.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.models.*;
import eus.fpsanturtzilh.repositories.ProduktuRepository;

@Service
public class ProduktuService {

    @Autowired
    private ProduktuRepository produktuRepository;

    // Método para obtener todos los productos
    public List<Produktuak> getAllProduktuak() {
        return produktuRepository.findAll();
    }

    // Método para actualizar un producto existente
    public Produktuak updateProduktu(Produktuak produktuak) {
        // Verificar si el producto existe
        Optional<Produktuak> existingProductOpt = produktuRepository.findById(produktuak.getId());
        
        if (existingProductOpt.isPresent()) {
            Produktuak existingProduct = existingProductOpt.get();
            
            // Actualizar los campos del producto
            existingProduct.setIzena(produktuak.getIzena());
            existingProduct.setDeskribapena(produktuak.getDeskribapena());
            existingProduct.setMarka(produktuak.getMarka());
            existingProduct.setStock(produktuak.getStock());
            existingProduct.setStock_alerta(produktuak.getStock_alerta());
            
            // Relacionar la categoría del producto
            if (produktuak.getKategoriak() != null) {
                existingProduct.setKategoriak(produktuak.getKategoriak());
            }

            // Actualizar los objetos embebidos
            if (produktuak.getData() != null) {
                existingProduct.setData(produktuak.getData());
            }

            // Guardar los cambios y devolver el producto actualizado
            return produktuRepository.save(existingProduct);
        } else {
            throw new RuntimeException("Produktu not found with ID: " + produktuak.getId());
        }
    }
}
