package eus.fpsanturtzilh.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.models.Langileak;
import eus.fpsanturtzilh.models.Material_maileguak;
import eus.fpsanturtzilh.models.Materialak;
import eus.fpsanturtzilh.repositories.LangileakRepository;
import eus.fpsanturtzilh.repositories.MaterialMaileguakRepository;
import eus.fpsanturtzilh.repositories.MaterialakRepository;

@Service
public class MaileguService {

	@Autowired
	private MaterialMaileguakRepository maileguRepository;
	private LangileakRepository langileRepository;
	private MaterialakRepository materialRepository;

	public List<Material_maileguak> getAllMaileguak() {
		return maileguRepository.findAll();
	}

	public Material_maileguak updateMaileguak(Material_maileguak maileguak) {
	    Optional<Material_maileguak> maileguZaharra = maileguRepository.findById(maileguak.getId());

	    if (maileguZaharra.isPresent()) {
	        Material_maileguak mailegua = maileguZaharra.get();

	        if (maileguak.getHasieraData() != null) {
	            mailegua.setHasieraData(maileguak.getHasieraData());
	        }

	        if (maileguak.getAmaieraData() != null) {
	            mailegua.setAmaieraData(maileguak.getAmaieraData());
	        }

	        if (maileguak.getData() != null) {
	            mailegua.setData(maileguak.getData());
	        }

	        // Actualizar el material si se proporciona un ID
	        if (maileguak.getIdMateriala() != null) {
	            Optional<Materialak> materialOpt = materialRepository.findById(maileguak.getIdMateriala());
	            materialOpt.ifPresent(mailegua::setMateriala);
	        }

	        // Actualizar el langilea si se proporciona un ID
	        if (maileguak.getIdLangilea() != null) {
	            Optional<Langileak> langileaOpt = langileRepository.findById(maileguak.getIdLangilea());
	            langileaOpt.ifPresent(mailegua::setLangilea);
	        }

	        return maileguRepository.save(mailegua);
	    } else {
	        throw new RuntimeException("Mailegua ez da aurkitu: " + maileguak.getId());
	    }
	}
}
