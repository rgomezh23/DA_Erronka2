package eus.fpsanturtzilh.services;

import eus.fpsanturtzilh.models.Materialak;
import eus.fpsanturtzilh.repositories.MaterialakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MaterialaService {

    @Autowired
    private MaterialakRepository materialakRepository;

    // Obtener todos los materiales sin "ezabatze_data" (soft delete)
    public List<Materialak> getAllMaterialak() {
        return materialakRepository.findByDataEzabatze_DataIsNull();
    }

    // Crear un nuevo material
    public Materialak createMateriala(Materialak materialak) {
        return materialakRepository.save(materialak);
    }

    // Actualizar un material
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

    // Eliminar un material (soft delete)

    public void softDeleteMateriala(Integer id) {
        Optional<Materialak> existingMaterial = materialakRepository.findById(id);
        if (existingMaterial.isPresent()) {
            Materialak material = existingMaterial.get();
            
            // Convierte LocalDate a java.sql.Date y establece el valor en 'ezabatze_data'
            material.getData().setEzabatze_data(Date.valueOf(LocalDate.now()));  // Usamos Date.valueOf() para convertir LocalDate a Date
            
            materialakRepository.save(material);
        } else {
            throw new RuntimeException("Materiala ez da aurkitu: " + id);
        }
    }


    // Obtener materiales eliminados
    public List<Materialak> getSoftDeletedMaterialak() {
        return materialakRepository.findByDataEzabatze_DataIsNotNull();
    }
}
