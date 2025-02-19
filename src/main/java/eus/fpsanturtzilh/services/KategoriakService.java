package eus.fpsanturtzilh.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.models.Kategoriak;
import eus.fpsanturtzilh.repositories.KategoriakRepository;

@Service
public class KategoriakService {
	@Autowired
	private KategoriakRepository kategoriaRepository;

	public List<Kategoriak> getAllKategoriak() {
		return kategoriaRepository.findAll();
	}

	public Kategoriak updateKategoria(Kategoriak bezero) {

		Optional<Kategoriak> kategoriaZaharra = kategoriaRepository.findById(bezero.getId());

		if (kategoriaZaharra.isPresent()) {
			Kategoriak kategoriaBerria = kategoriaZaharra.get();

			kategoriaBerria.setIzena(bezero.getIzena());

			if (bezero.getData() != null) {
				kategoriaBerria.setData(bezero.getData());
			}

			return kategoriaRepository.save(kategoriaBerria);
		} else {
			throw new RuntimeException("Bezeroaren id ez da aurkitu: " + bezero.getId());
		}
	}

	public Kategoriak createNewKategoria(Kategoriak bezero) {
		return kategoriaRepository.save(bezero);
	}

	public void trueDelete(Integer id) {
		kategoriaRepository.deleteById(id);
	}
}
