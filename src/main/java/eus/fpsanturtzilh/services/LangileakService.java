package eus.fpsanturtzilh.services;

import eus.fpsanturtzilh.models.Langileak;
import eus.fpsanturtzilh.models.Taldeak;
import eus.fpsanturtzilh.repositories.LangileakRepository;
import eus.fpsanturtzilh.repositories.TaldeakRepository;

import org.springframework.stereotype.Service;

import java.sql.Date;
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

	public List<Langileak> findAll() {
		return langileakRepository.findAll();
	}

	public List<Langileak> findAllNotDeleted() {
		return langileakRepository.findAll().stream()
				.filter(langile -> langile.getData() == null || langile.getData().getEzabatze_data() == null).toList();
	}

	public List<Langileak> findAllDeleted() {
		return langileakRepository.findAll().stream()
				.filter(langile -> langile.getData() != null && langile.getData().getEzabatze_data() != null).toList();
	}

	public Langileak updateLangile(Langileak langile) {
		return langileakRepository.findById(langile.getId()).map(langileZaharra -> {
			langileZaharra.setKode(langile.getKode());
			langileZaharra.setIzena(langile.getIzena());
			langileZaharra.setAbizenak(langile.getAbizenak());

			if (langile.getData() != null) {
				if (langile.getData().getSortze_data() != null) {
					langileZaharra.getData().setSortze_data(langile.getData().getSortze_data());
				}
				if (langile.getData().getEguneratze_data() != null) {
					langileZaharra.getData().setEguneratze_data(langile.getData().getEguneratze_data());
				}
				if (langile.getData().getEzabatze_data() != null) {
					langileZaharra.getData().setEzabatze_data(langile.getData().getEzabatze_data());
				}
			}

			return langileakRepository.save(langileZaharra);
		}).orElseThrow(() -> new RuntimeException("Langile hori ez dago. ID: " + langile.getId()));
	}

	public Langileak deleteLangile(Langileak langile) {
		return langileakRepository.findById(langile.getId()).map(langileEzabatuta -> {
			langileEzabatuta.getData().setEzabatze_data(new Date(System.currentTimeMillis()));
			return langileakRepository.save(langileEzabatuta);
		}).orElseThrow(() -> new RuntimeException("Langilea ez da aurkitu: " + langile.getId()));
	}

	public Langileak createNewLangile(Langileak langile) {
		if (langile.getKode() == null || langile.getKode().isEmpty()) {
			throw new IllegalArgumentException("Kodea ezin da hutsik egon");
		}

		Taldeak taldeak = taldeakRepository.findById(langile.getKode())
				.orElseThrow(() -> new RuntimeException("Taldeak ez da aurkitu: " + langile.getKode()));

		langile.setTaldeak(taldeak);
		return langileakRepository.save(langile);
	}

	public Langileak deleteLangileById(int id) {
		Optional<Langileak> langileOptional = langileakRepository.findById(id);

		if (langileOptional.isPresent()) {
			Langileak langile = langileOptional.get();
			langile.getData().setEzabatze_data(new Date(System.currentTimeMillis()));
			return langileakRepository.save(langile);
		} else {
			throw new RuntimeException("Langilea ez da aurkitu: " + id);
		}
	}
}
