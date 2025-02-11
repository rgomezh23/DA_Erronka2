package eus.fpsanturtzilh.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.models.Kolore_historialak;
import eus.fpsanturtzilh.repositories.KoloreHistorialakRepository;

import java.util.List;
import java.util.Optional;

@Service
public class KoloreHistorialakService {

	@Autowired
	private KoloreHistorialakRepository koloreHistorialakRepository;

	public List<Kolore_historialak> getAllNotDeleted() {
		return koloreHistorialakRepository.findAllNotDeleted();
	}

	public List<Kolore_historialak> getAllDeleted() {
		return koloreHistorialakRepository.findAllDeleted();
	}

	public Kolore_historialak createNewKoloreHistorialak(Kolore_historialak koloreHistorialak) {
		return koloreHistorialakRepository.save(koloreHistorialak);
	}

	public Kolore_historialak updateKoloreHistorialak(Kolore_historialak koloreHistorialak) {
		Optional<Kolore_historialak> existingRecord = koloreHistorialakRepository.findById(koloreHistorialak.getId());
		if (existingRecord.isPresent()) {
			Kolore_historialak updatedRecord = existingRecord.get();
			updatedRecord.setBezero(koloreHistorialak.getBezero());
			updatedRecord.setProduktu_id(koloreHistorialak.getProduktu_id());
			updatedRecord.setData(koloreHistorialak.getData());
			updatedRecord.setKantitatea(koloreHistorialak.getKantitatea());
			updatedRecord.setBolumena(koloreHistorialak.getBolumena());
			updatedRecord.setOharrak(koloreHistorialak.getOharrak());
			updatedRecord.setDataSimple(koloreHistorialak.getDataSimple());
			return koloreHistorialakRepository.save(updatedRecord);
		}
		return null;
	}

	public Kolore_historialak deleteKoloreHistorialakById(int id) {
		Optional<Kolore_historialak> existingRecord = koloreHistorialakRepository.findById(id);
		if (existingRecord.isPresent()) {
			Kolore_historialak record = existingRecord.get();
			record.getDataSimple().setEzabatze_data(new java.sql.Date(System.currentTimeMillis()));
			return koloreHistorialakRepository.save(record);
		}
		return null;
	}

	public boolean hardDeleteKoloreHistorialakById(int id) {
		Optional<Kolore_historialak> existingRecord = koloreHistorialakRepository.findById(id);
		if (existingRecord.isPresent()) {
			koloreHistorialakRepository.delete(existingRecord.get());
			return true;
		}
		return false;
	}
}
