package eus.fpsanturtzilh.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.models.Langileak;
import eus.fpsanturtzilh.models.Taldeak;
import eus.fpsanturtzilh.repositories.TaldeakRepository;
import jakarta.transaction.Transactional;

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

	@Transactional
	public Taldeak updateTaldeak(Taldeak taldeak) {
	    // Validar datos de entrada
	    if (taldeak.getKodea() == null) {
	        throw new IllegalArgumentException("Talde kodea null da.");
	    }

	    Optional<Taldeak> taldeBerria = taldeakRepository.findByKodea(taldeak.getKodea());

	    if (taldeBerria.isPresent()) {
	        Taldeak taldeZaharra = taldeBerria.get();

	        taldeZaharra.setIzena(taldeak.getIzena());

	        if (taldeak.getLangileak() != null && !taldeak.getLangileak().isEmpty()) {
	            taldeZaharra.getLangileak().clear(); 
	            for (Langileak langileak : taldeak.getLangileak()) {
	                langileak.setTaldeak(taldeZaharra); 
	                taldeZaharra.getLangileak().add(langileak);
	            }
	        }

	        if (taldeak.getData() != null) {
	            taldeZaharra.setData(taldeak.getData());
	        }

	        return taldeakRepository.save(taldeZaharra);
	    } else {
	        throw new RuntimeException("Taldeak no encontrado con código: " + taldeak.getKodea());
	    }
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
	
	@Transactional
	public void hardDeleteTaldeaByKodea(String kodea) {
	    if (taldeakRepository.existsById(kodea)) {
	        taldeakRepository.deleteById(kodea);
	    } else {
	        throw new RuntimeException("Taldea ez da aurkitu kode honekin: " + kodea);
	    }
	}

}
