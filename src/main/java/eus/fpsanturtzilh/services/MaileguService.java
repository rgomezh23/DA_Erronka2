package eus.fpsanturtzilh.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.models.Material_maileguak;
import eus.fpsanturtzilh.repositories.MaterialMaileguakRepository;

@Service
public class MaileguService {

    @Autowired
    private MaterialMaileguakRepository maileguRepository;

    // Obtener todos los registros de Material_maileguak
    public List<Material_maileguak> getAllMaileguak() {
        return maileguRepository.findAll();
    }

    // Actualizar un registro de Material_maileguak
    public Material_maileguak updateMaileguak(Material_maileguak maileguak) {
        Optional<Material_maileguak> maileguZaharra = maileguRepository.findById(maileguak.getId());
        
        if (maileguZaharra.isPresent()) {
        	Material_maileguak mailegua = maileguZaharra.get();
            
            // Aquí se debería asignar correctamente las nuevas fechas
            if (maileguak.getHasieraData() != null) {
                mailegua.setHasieraData(maileguak.getHasieraData());
            }

            if (maileguak.getAmaieraData() != null) {
                mailegua.setAmaieraData(maileguak.getAmaieraData());
            }

            if (maileguak.getData() != null) {
                mailegua.setData(maileguak.getData());
            }

            if (maileguak.getLangilea() != null) {
                mailegua.setLangilea(maileguak.getLangilea());  // Aquí asignamos el nuevo langilea
            }

            return maileguRepository.save(mailegua);
        } else {
            throw new RuntimeException("Mailegua ez da aurkitu: " + maileguak.getId());
        }
    }
}
