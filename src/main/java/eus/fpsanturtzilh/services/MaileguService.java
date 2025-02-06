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

			if (maileguak.getLangilea() != null) {
				mailegua.setLangilea(maileguak.getLangilea());
			}

			return maileguRepository.save(mailegua);
		} else {
			throw new RuntimeException("Mailegua ez da aurkitu: " + maileguak.getId());
		}
	}
}
