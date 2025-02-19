package eus.fpsanturtzilh.services;

import eus.fpsanturtzilh.models.Material_maileguak;
import eus.fpsanturtzilh.repositories.MaterialMaileguakRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MaileguService {

    private final MaterialMaileguakRepository materialMaileguakRepository;

    public MaileguService(MaterialMaileguakRepository materialMaileguakRepository) {
        this.materialMaileguakRepository = materialMaileguakRepository;
    }

 // Obtener todos los materiales no eliminados
    public List<Material_maileguak> findAllNotDeleted() {
        return materialMaileguakRepository.findAllNotDeleted();
    }

    // Obtener todos los materiales eliminados
    public List<Material_maileguak> findAllDeleted() {
        return materialMaileguakRepository.findAllDeleted();
    }

    public Optional<Material_maileguak> findById(int id) {
        return materialMaileguakRepository.findById(id);
    }

    public Material_maileguak createNewMaterial(Material_maileguak materialMaileguak) {
        return materialMaileguakRepository.save(materialMaileguak);
    }

    public Material_maileguak updateMaterial(Material_maileguak materialMaileguak) {
        return materialMaileguakRepository.findById(materialMaileguak.getId()).map(existingMaterial -> {
            existingMaterial.setIdLangilea(materialMaileguak.getIdLangilea());
            existingMaterial.setMateriala_id(materialMaileguak.getMateriala_id());
            existingMaterial.setHasieraData(materialMaileguak.getHasieraData());
            existingMaterial.setAmaieraData(materialMaileguak.getAmaieraData());
            existingMaterial.setData(materialMaileguak.getData());
            return materialMaileguakRepository.save(existingMaterial);
        }).orElseThrow(() -> new RuntimeException("Materiala ez dago. ID: " + materialMaileguak.getId()));
    }

    public Material_maileguak softDeleteMaterial(int id) {
        Optional<Material_maileguak> materialOptional = materialMaileguakRepository.findById(id);
        if (materialOptional.isPresent()) {
            Material_maileguak material = materialOptional.get();
            material.getData().setEzabatze_data(new Date(System.currentTimeMillis()));
            return materialMaileguakRepository.save(material);
        } else {
            throw new RuntimeException("Materiala ez da aurkitu: " + id);
        }
    }

    public void hardDeleteMaterial(int id) {
        materialMaileguakRepository.deleteById(id);
    }
}
