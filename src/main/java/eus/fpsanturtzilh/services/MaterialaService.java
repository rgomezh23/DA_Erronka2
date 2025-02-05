package eus.fpsanturtzilh.services;

import eus.fpsanturtzilh.models.Materialak;
import eus.fpsanturtzilh.repositories.MaterialakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialaService {

    @Autowired
    private MaterialakRepository materialakRepository;

    // Obtener todos los materiales
    public List<Materialak> getAllMaterialak() {
        return materialakRepository.findAll();
    }

    // Crear un nuevo material
    public Materialak createMateriala(Materialak materialak) {
        return materialakRepository.save(materialak);
    }

    // Actualizar un material existente
    public Materialak updateMateriala(Materialak materialak) {
        Optional<Materialak> materialZaharra = materialakRepository.findById(materialak.getId());
        
        if (materialZaharra.isPresent()) {
            Materialak existingMaterial = materialZaharra.get();
            existingMaterial.setIzena(materialak.getIzena());
            existingMaterial.setEtiketa(materialak.getEtiketa());
            return materialakRepository.save(existingMaterial);
        } else {
            throw new RuntimeException("Materiala ez da aurkitu: " + materialak.getId());
        }
    }

    // Obtener un material por su ID
    public Optional<Materialak> getMaterialaById(Integer id) {
        return materialakRepository.findById(id);
    }

    // Eliminar un material por su ID
    public void deleteMateriala(Integer id) {
        materialakRepository.deleteById(id);
    }
}
