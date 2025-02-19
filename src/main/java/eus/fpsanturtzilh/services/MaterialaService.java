package eus.fpsanturtzilh.services;

import eus.fpsanturtzilh.models.Materialak;
import eus.fpsanturtzilh.repositories.MaterialakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MaterialaService {

	@Autowired
	private MaterialakRepository materialakRepository;

	public List<Materialak> getAllMaterialak() {
		return materialakRepository.findByDataEzabatze_DataIsNull();
	}

	public Materialak createMateriala(Materialak materialak) {
		return materialakRepository.save(materialak);
	}

	public Materialak updateMateriala(Materialak materialak) {
		Optional<Materialak> materialZaharra = materialakRepository.findById(materialak.getId());

		if (materialZaharra.isPresent()) {
			Materialak existingMaterial = materialZaharra.get();
			existingMaterial.setIzena(materialak.getIzena());
			existingMaterial.setEtiketa(materialak.getEtiketa());
			if(existingMaterial !=null) {
				existingMaterial.setData(materialak.getData());
			}
			return materialakRepository.save(existingMaterial);
		} else {
			throw new RuntimeException("Materiala ez da aurkitu: " + materialak.getId());
		}
	}

	public Optional<Materialak> getMaterialaById(Integer id) {
		return materialakRepository.findById(id);
	}

	public void softDeleteMateriala(Integer id) {
		Optional<Materialak> existingMaterial = materialakRepository.findById(id);
		if (existingMaterial.isPresent()) {
			Materialak material = existingMaterial.get();

			material.getData().setEzabatze_data(Date.valueOf(LocalDate.now()));

			materialakRepository.save(material);
		} else {
			throw new RuntimeException("Materiala ez da aurkitu: " + id);
		}
	}

	public List<Materialak> getSoftDeletedMaterialak() {
		return materialakRepository.findByDataEzabatze_DataIsNotNull();
	}
}
