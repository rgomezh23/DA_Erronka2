package eus.fpsanturtzilh.services;

import eus.fpsanturtzilh.models.Langileak;
import eus.fpsanturtzilh.repositories.LangileakRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LangileakService {

    private final LangileakRepository langileakRepository;

    public LangileakService(LangileakRepository langileakRepository) {
        this.langileakRepository = langileakRepository;
    }

    /**
     * Recupera todos los registros de Langileak de la base de datos.
     * @return Lista de Langileak
     */
    public List<Langileak> findAll() {
        return langileakRepository.findAll();
    }
}
