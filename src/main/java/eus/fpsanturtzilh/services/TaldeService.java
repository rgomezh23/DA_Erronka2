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

	    public List<Taldeak> getAllTaldeak() {
	        return taldeakRepository.findAll();
	    }

	    public Taldeak updateTaldeak(Taldeak taldeak) {
	        Optional<Taldeak> taldeBerria = taldeakRepository.findByKodea(taldeak.getKodea());
	        
	        if (taldeBerria.isPresent()) {
	        	Taldeak taldeZaharra = taldeBerria.get();
	            
	            taldeZaharra.setKodea(taldeak.getKodea());
	            taldeZaharra.setIzena(taldeak.getIzena());
	            
	            if (taldeak.getLangileak() != null) {
	                taldeZaharra.setLangileak(taldeak.getLangileak());
	            }

	            if (taldeak.getData() != null) {
	                taldeZaharra.setData(taldeak.getData());
	        } else {
	            throw new RuntimeException("Talde hori ez dago. Kodea: " + taldeak.getKodea());
	        }
	            return taldeakRepository.save(taldeZaharra);
	    }
	        return null;
	}
	    
	    public Taldeak deleteTaldea(Taldeak taldea) {
	    	
	        Optional<Taldeak> taldeZaharra = taldeakRepository.findByKodea(taldea.getKodea());
	        
	        if (taldeZaharra.isPresent()) {
	        	Taldeak taldeEzabatuta = taldeZaharra.get();
	            
	            if (taldea.getData() != null) {
	                taldeEzabatuta.getData().setEzabatze_data(taldea.getData().getEzabatze_data());
	            }

	            return taldeakRepository.save(taldeEzabatuta);
	        } else {
	            throw new RuntimeException("Taldearen id ez da aurkitu: " + taldea.getKodea());
	        }
	    }
	   
	    public Taldeak createNewTalde(Taldeak taldea) {
	        return taldeakRepository.save(taldea);
	    }
}
