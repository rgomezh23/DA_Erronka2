package eus.fpsanturtzilh.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.models.Materialak;
import eus.fpsanturtzilh.repositories.MaterialRepository;


@Service
public class MaterialaService {

    @Autowired
    private MaterialRepository materialRepository;

    public List<Materialak> getAllMaterialak() {
        return materialRepository.findAll();
    }

    public Materialak updateMateriala(Materialak materialak) {

        Optional<Materialak> existingMateriala = materialRepository.findById(materialak.getId());
        
        if (existingMateriala.isPresent()) {
            Materialak materialaEguneratuta = existingMateriala.get();
            
            materialaEguneratuta.setIzena(materialak.getIzena());
            materialaEguneratuta.setEtiketa(materialak.getEtiketa());
           
            if (materialak.getMaileguak() != null) {
                materialaEguneratuta.setMaileguak(materialak.getMaileguak());
            }

            if (materialak.getData() != null) {
                materialaEguneratuta.setData(materialak.getData());
            }

            return materialRepository.save(materialaEguneratuta);
        } else {
            throw new RuntimeException("Materialaren id ez da aurkitu: " + materialak.getId());
        }
    }
}
