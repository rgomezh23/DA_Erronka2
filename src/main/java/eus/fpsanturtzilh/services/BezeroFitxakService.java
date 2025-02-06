package eus.fpsanturtzilh.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.models.Bezero_fitxak;
import eus.fpsanturtzilh.repositories.BezeroFitxakRepository;

@Service
public class BezeroFitxakService {

	@Autowired
	private BezeroFitxakRepository bezeroRepository;

	public List<Bezero_fitxak> getAllBezeroFitxak() {
		return bezeroRepository.findAll();
	}

	public Bezero_fitxak updateBezero(Bezero_fitxak bezero) {

		Optional<Bezero_fitxak> bezeroZaharra = bezeroRepository.findById(bezero.getId());

		if (bezeroZaharra.isPresent()) {
			Bezero_fitxak bezeroBerria = bezeroZaharra.get();

			bezeroBerria.setIzena(bezero.getIzena());
			bezeroBerria.setAbizena(bezero.getAbizena());
			bezeroBerria.setAzal_sentikorra(bezero.getAzal_sentikorra());
			bezeroBerria.setTelefonoa(bezero.getTelefonoa());

			if (bezero.getData() != null) {
				bezeroBerria.setData(bezero.getData());
			}

			return bezeroRepository.save(bezeroBerria);
		} else {
			throw new RuntimeException("Bezeroaren id ez da aurkitu: " + bezero.getId());
		}
	}

	public Bezero_fitxak deleteBezero(Bezero_fitxak bezero) {

		Optional<Bezero_fitxak> bezeroZaharra = bezeroRepository.findById(bezero.getId());

		if (bezeroZaharra.isPresent()) {
			Bezero_fitxak bezeroEzabatuta = bezeroZaharra.get();

			if (bezero.getData() != null) {
				bezeroEzabatuta.getData().setEzabatze_data(bezero.getData().getEzabatze_data());
			}

			return bezeroRepository.save(bezeroEzabatuta);
		} else {
			throw new RuntimeException("Bezeroaren id ez da aurkitu: " + bezero.getId());
		}
	}

	public Bezero_fitxak createNewBezero(Bezero_fitxak bezero) {
		return bezeroRepository.save(bezero);
	}

	public List<Bezero_fitxak> getAllNotDeletedBezeroFitxak() {
		return bezeroRepository.findAllNotDeleted();
	}

	public List<Bezero_fitxak> getAllDeletedBezeroFitxak() {
		return bezeroRepository.findAllDeleted();
	}

	public void trueDelete(Integer id) {
		bezeroRepository.deleteById(id);
	}

	public Bezero_fitxak softDeleteBezero(Integer id) {
		Optional<Bezero_fitxak> bezeroZaharra = bezeroRepository.findById(id);

		if (bezeroZaharra.isPresent()) {
			Bezero_fitxak bezeroEzabatuta = bezeroZaharra.get();

			if (bezeroEzabatuta.getData() != null) {
				bezeroEzabatuta.getData().setEzabatze_data(new Date(System.currentTimeMillis()));
			} else {
				throw new RuntimeException("Data egitura faltan da.");
			}

			return bezeroRepository.save(bezeroEzabatuta);
		} else {
			throw new RuntimeException("Bezeroaren id ez da aurkitu: " + id);
		}
	}

}