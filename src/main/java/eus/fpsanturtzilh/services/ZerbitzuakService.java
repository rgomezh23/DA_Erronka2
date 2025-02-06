package eus.fpsanturtzilh.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.models.Zerbitzuak;
import eus.fpsanturtzilh.repositories.ZerbitzuakRepository;

@Service
public class ZerbitzuakService {

	@Autowired
	private ZerbitzuakRepository zerbitzuRepository;

	public List<Zerbitzuak> getAllZerbitzuak() {
		return zerbitzuRepository.findAll();
	}

	public Zerbitzuak updateZerbitzuak(Zerbitzuak zerbitzuak) {
		Optional<Zerbitzuak> zerbitzua = zerbitzuRepository.findById(zerbitzuak.getId());

		if (zerbitzua.isPresent()) {
			Zerbitzuak zerbitzuzaharra = zerbitzua.get();

			zerbitzuzaharra.setIzena(zerbitzuak.getIzena());
			zerbitzuzaharra.setEtxeko_prezioa(zerbitzuak.getEtxeko_prezioa());
			;
			zerbitzuzaharra.setEtxeko_prezioa(zerbitzuak.getEtxeko_prezioa());

			if (zerbitzuak.getData() != null) {
				zerbitzuzaharra.setData(zerbitzuak.getData());
			}

			return zerbitzuRepository.save(zerbitzuzaharra);
		} else {
			throw new RuntimeException("Produktu not found with ID: " + zerbitzuak.getId());
		}
	}
}
