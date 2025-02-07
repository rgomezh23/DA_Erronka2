package eus.fpsanturtzilh.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.models.Data;
import eus.fpsanturtzilh.models.Zerbitzuak;
import eus.fpsanturtzilh.repositories.ZerbitzuakRepository;

@Service
public class ZerbitzuakService {

	@Autowired
	private ZerbitzuakRepository zerbitzuRepository;

	public List<Zerbitzuak> getZerbitzuakWithEzabatzeDataNull() {
		return zerbitzuRepository.findByEzabatzeDataIsNull();
	}

	public List<Zerbitzuak> getZerbitzuakWithEzabatzeDataNotNull() {
		return zerbitzuRepository.findByEzabatzeDataIsNotNull();
	}

	public Zerbitzuak updateZerbitzuak(Zerbitzuak zerbitzuak) {
		Optional<Zerbitzuak> zerbitzua = zerbitzuRepository.findById(zerbitzuak.getId());

		if (zerbitzua.isPresent()) {
			Zerbitzuak zerbitzuzaharra = zerbitzua.get();
			zerbitzuzaharra.setIzena(zerbitzuak.getIzena());
			zerbitzuzaharra.setEtxeko_prezioa(zerbitzuak.getEtxeko_prezioa());
			zerbitzuzaharra.setKanpoko_prezioa(zerbitzuak.getKanpoko_prezioa());

			if (zerbitzuak.getData() != null) {
				zerbitzuzaharra.setData(zerbitzuak.getData());
			}

			return zerbitzuRepository.save(zerbitzuzaharra);
		} else {
			throw new RuntimeException("Zerbitzua ez da aurkitu ID-rekin: " + zerbitzuak.getId());
		}
	}

	public Zerbitzuak insertZerbitzuak(Zerbitzuak zerbitzuak) {
		return zerbitzuRepository.save(zerbitzuak);
	}

	public boolean softDeleteZerbitzuak(int id) {
		Optional<Zerbitzuak> optionalZerbitzuak = zerbitzuRepository.findById(id);

		if (optionalZerbitzuak.isPresent()) {
			Zerbitzuak zerbitzua = optionalZerbitzuak.get();

			if (zerbitzua.getData() == null) {
				zerbitzua.setData(new Data());
			}

			zerbitzua.getData().setEzabatze_data(Date.valueOf(LocalDate.now()));

			zerbitzuRepository.save(zerbitzua);
			return true;
		}

		return false;
	}

	public boolean hardDeleteZerbitzuak(int id) {
		if (zerbitzuRepository.existsById(id)) {
			zerbitzuRepository.deleteById(id);
			return true;
		}

		return false;
	}

	public Optional<Zerbitzuak> getZerbitzuaById(int id) {
		return zerbitzuRepository.findById(id);
	}

}
