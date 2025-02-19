package eus.fpsanturtzilh.services;

import java.time.LocalDate;
// import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.models.Hitzorduak;
import eus.fpsanturtzilh.repositories.HitzorduakRepository;

@Service
public class HitzorduakService {

	@Autowired
	private HitzorduakRepository hitzorduakRepository;

	public List<Hitzorduak> getAllHitzorduak() {
		return hitzorduakRepository.findAllNotDeleted();
	}

	public Hitzorduak updateHitzorduak(Hitzorduak hitzorduak) throws Exception {
		Hitzorduak existingCita = hitzorduakRepository.findById(hitzorduak.getId())
				.orElseThrow(() -> new Exception("Cita no encontrada"));

		existingCita.setEserlekua(hitzorduak.getEserlekua());
		existingCita.setId_langilea(hitzorduak.getId_langilea());
		existingCita.setData(hitzorduak.getData());
		existingCita.setHasiera_ordua(hitzorduak.getHasiera_ordua());
		existingCita.setAmaiera_ordua(hitzorduak.getAmaiera_ordua());
		existingCita.setIzena(hitzorduak.getIzena());
		existingCita.setTelefonoa(hitzorduak.getTelefonoa());
		existingCita.setDeskribapena(hitzorduak.getDeskribapena());
		existingCita.setEtxekoa(hitzorduak.getEtxekoa());
		existingCita.setPrezio_totala(hitzorduak.getPrezio_totala());

		return hitzorduakRepository.save(existingCita);
	}

	public Hitzorduak saveHitzorduak(Hitzorduak hitzorduak) {
		return hitzorduakRepository.save(hitzorduak);
	}

	public List<Hitzorduak> getAppointmentsByDate(LocalDate date) {
		System.out.println(date);
		return hitzorduakRepository.findBySortzeData(date);
	}

	public boolean deleteHitzorduak(int id) {
		if (hitzorduakRepository.existsById(id)) {
			hitzorduakRepository.deleteById(id);
			return true;
		}
		return false;
	}

}