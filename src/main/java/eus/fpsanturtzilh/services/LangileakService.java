package eus.fpsanturtzilh.services;

import eus.fpsanturtzilh.models.Langileak;
import eus.fpsanturtzilh.models.Taldeak;
import eus.fpsanturtzilh.repositories.LangileakRepository;
import eus.fpsanturtzilh.repositories.TaldeakRepository;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class LangileakService {

    private final LangileakRepository langileakRepository;
    private final TaldeakRepository taldeakRepository;
    

    public LangileakService(LangileakRepository langileakRepository, TaldeakRepository taldeakRepository) {
        this.langileakRepository = langileakRepository;
        this.taldeakRepository = taldeakRepository;
    }

    /**
     * Recupera todos los registros de Langileak de la base de datos.
     * @return Lista de Langileak
     */
    public List<Langileak> findAll() {
        return langileakRepository.findAll();
    }
    
    public Langileak updateLangile(Langileak langile) {
        Optional<Langileak> langileBerria = langileakRepository.findById(langile.getId());
        
        if (langileBerria.isPresent()) {
        	Langileak langileZaharra = langileBerria.get();
            
            langileZaharra.setKode(langile.getKode());
            langileZaharra.setIzena(langile.getIzena());
            langileZaharra.setAbizenak(langile.getAbizenak());
            

            if (langile.getData() != null) {
                langileZaharra.setData(langile.getData());
        } else {
            throw new RuntimeException("Langile hori ez dago. Kodea: " + langile.getId());
        }
            return langileakRepository.save(langileZaharra);
    }
        return null;
}
    
    public Langileak deleteLangile(Langileak taldea) {
    	
        Optional<Langileak> langileZaharra = langileakRepository.findById(taldea.getId());
        
        if (langileZaharra.isPresent()) {
        	Langileak langileEzabatuta = langileZaharra.get();
            
            if (taldea.getData() != null) {
                langileEzabatuta.getData().setEzabatze_data(taldea.getData().getEzabatze_data());
            }

            return langileakRepository.save(langileEzabatuta);
        } else {
            throw new RuntimeException("Taldearen id ez da aurkitu: " + taldea.getKode());
        }
    }
   
    public Langileak createNewLangile(Langileak langile) {
        // Verificar que el 'kodea' no sea null o vacío
        if (langile.getKode() == null || langile.getKode().isEmpty()) {
            throw new IllegalArgumentException("El campo 'kodea' no puede ser null o vacío");
        }

        // Buscar el 'Taldeak' correspondiente al 'kodea' recibido
        Taldeak taldeak = taldeakRepository.findById(langile.getKode())
                .orElseThrow(() -> new RuntimeException("Taldeak ez da aurkitu: " + langile.getKode()));

        // Asociar el 'Taldeak' encontrado al 'Langileak'
        langile.setTaldeak(taldeak);

        // El 'id' será generado automáticamente por la base de datos
        return langileakRepository.save(langile);
    }
}
