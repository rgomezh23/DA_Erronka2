package eus.fpsanturtzilh.services;

import org.springframework.stereotype.Service;
import eus.fpsanturtzilh.models.Produktu_Mugimenduak;
import eus.fpsanturtzilh.repositories.ProduktuMugimenduakRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ProduktuMugimenduakService {
	private final ProduktuMugimenduakRepository produktuMugimenduakRepository;

	public ProduktuMugimenduakService(ProduktuMugimenduakRepository produktuMugimenduakRepository) {
		this.produktuMugimenduakRepository = produktuMugimenduakRepository;
	}

	public List<Produktu_Mugimenduak> findAllNotDeleted() {
		return produktuMugimenduakRepository.findAllActive();
	}

	public List<Produktu_Mugimenduak> findAllDeleted() {
		return produktuMugimenduakRepository.findAllDeleted();
	}

	public Optional<Produktu_Mugimenduak> getProduktuMugimenduakById(int id) {
		return produktuMugimenduakRepository.findById(id);
	}

	public Produktu_Mugimenduak createNewProduktuMugimendu(Produktu_Mugimenduak produktuMugimenduak) {
		return produktuMugimenduakRepository.save(produktuMugimenduak);
	}

	public Produktu_Mugimenduak updateProduktuMugimendu(Produktu_Mugimenduak updatedData) {
		return produktuMugimenduakRepository.findById(updatedData.getId()).map(existing -> {
			existing.setProduktuak(updatedData.getProduktuak());
			existing.setKantitatea(updatedData.getKantitatea());
			existing.setData(updatedData.getData());
			existing.setLangilea(updatedData.getLangilea());
			existing.setData_Zutabea(updatedData.getData_Zutabea());
			return produktuMugimenduakRepository.save(existing);
		}).orElseThrow(() -> new RuntimeException("Produktu mugimendua ez da aurkitu!"));
	}

	public Produktu_Mugimenduak softDeleteProduktuMugimendu(int id) {
		return produktuMugimenduakRepository.findById(id).map(existing -> {
			existing.getData().setEzabatze_data(new java.sql.Date(System.currentTimeMillis()));
			return produktuMugimenduakRepository.save(existing);
		}).orElseThrow(() -> new RuntimeException("Produktu mugimendua ez da aurkitu!"));
	}

	public void hardDeleteProduktuMugimendu(int id) {
		if (produktuMugimenduakRepository.existsById(id)) {
			produktuMugimenduakRepository.deleteById(id);
		} else {
			throw new RuntimeException("Produktu mugimendua ez da aurkitu!");
		}
	}
}
