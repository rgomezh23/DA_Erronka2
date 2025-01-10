package eus.fpsanturtzilh.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.models.Materialak;
import eus.fpsanturtzilh.repositories.MaterialakRepository;


@Service
public class MaterialaService {

    @Autowired
    private MaterialakRepository materialaRepository;

    public List<Materialak> getAllMaterialak() {
        return materialaRepository.findAll();
    }

    public Materialak updateMateriala(Materialak materialak) {
        Optional<Materialak> existingProductOpt = materialaRepository.findById(materialak.getId());
        
        if (existingProductOpt.isPresent()) {
            Materialak materiala = existingProductOpt.get();
            

            materiala.setIzena(materialak.getIzena());
            materiala.setEtiketa(materialak.getEtiketa());
       
            if (materialak.getMaileguak() != null) {
                materiala.setMaileguak(materialak.getMaileguak());
            }

            if (materialak.getData() != null) {
                materiala.setData(materialak.getData());
            }

            return materialaRepository.save(materiala);
        } else {
            throw new RuntimeException("Materiala ez da aurkitu: " + materialak.getId());
        }
    }
}
