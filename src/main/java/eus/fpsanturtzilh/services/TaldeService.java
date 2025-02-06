package eus.fpsanturtzilh.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.models.Taldeak;
import eus.fpsanturtzilh.repositories.TaldeakRepository;

@Service
public class TaldeService {
	@Autowired
	private TaldeakRepository taldeakRepository;

	public List<Taldeak> getAllNotDeleted() {
		return taldeakRepository.findAllNotDeleted();
	}

	public List<Taldeak> getAllDeleted() {
		return taldeakRepository.findAllDeleted();
	}

	public Taldeak updateTaldeak(Taldeak taldeak) {
		Optional<Taldeak> taldeBerria = taldeakRepository.findByKodea(taldeak.getKodea());
		if (taldeBerria.isPresent()) {
			Taldeak taldeZaharra = taldeBerria.get();
			taldeZaharra.setIzena(taldeak.getIzena());
			if (taldeak.getLangileak() != null) {
				taldeZaharra.setLangileak(taldeak.getLangileak());
			}
			if (taldeak.getData() != null) {
				taldeZaharra.setData(taldeak.getData());
			}
			return taldeakRepository.save(taldeZaharra);
		}
		return null;
	}

	public Taldeak deleteTaldeaByKodea(String kodea) {
		Optional<Taldeak> taldeZaharra = taldeakRepository.findByKodea(kodea);
		if (taldeZaharra.isPresent()) {
			Taldeak taldeEzabatuta = taldeZaharra.get();
			taldeEzabatuta.getData().setEzabatze_data(new java.sql.Date(System.currentTimeMillis()));
			return taldeakRepository.save(taldeEzabatuta);
		}
		return null;
	}

	public Taldeak createNewTalde(Taldeak taldea) {
		return taldeakRepository.save(taldea);
	}
}
