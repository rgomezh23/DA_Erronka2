package eus.fpsanturtzilh.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.models.Hitzorduak;
import eus.fpsanturtzilh.repositories.HitzorduakRepository;

@Service
public class HitzorduakService {

	@Autowired
	private HitzorduakRepository hitzorduakRepository;

	// Obtener todas las citas
	public List<Hitzorduak> getAllHitzorduak() {
		return hitzorduakRepository.findAll();
	}

	// Actualizar una cita existente
	public Hitzorduak updateHitzorduak(Hitzorduak hitzorduak) {
		Optional<Hitzorduak> existingAppointmentOpt = hitzorduakRepository.findById(hitzorduak.getId());

		if (existingAppointmentOpt.isPresent()) {
			Hitzorduak existingAppointment = existingAppointmentOpt.get();

			// Actualizar los campos de la cita
			existingAppointment.setIzena(hitzorduak.getIzena());
			existingAppointment.setEserlekua(hitzorduak.getEserlekua());
			existingAppointment.setTelefonoa(hitzorduak.getTelefonoa());
			existingAppointment.setDeskribapena(hitzorduak.getDeskribapena());
			existingAppointment.setData(hitzorduak.getData());
			existingAppointment.setEtxekoa(hitzorduak.getEtxekoa());
			existingAppointment.setPrezio_totala(hitzorduak.getPrezio_totala());
			existingAppointment.setDataSimple(hitzorduak.getDataSimple());

			// Relacionar el trabajador (Langileak) si es necesario
			if (hitzorduak.getLangileak() != null) {
				existingAppointment.setLangileak(hitzorduak.getLangileak());
			}

			return hitzorduakRepository.save(existingAppointment);
		} else {
			throw new RuntimeException("Hitzorduak not found with ID: " + hitzorduak.getId());
		}
	}

	// Obtener citas activas (citas que no tienen fecha de eliminación)
	public List<Hitzorduak> getActiveAppointments() {
		return hitzorduakRepository.findActiveAppointments();
	}

	// Obtener citas dentro de un rango de fechas
	public List<Hitzorduak> getAppointmentsBetweenDates(Date startDate, Date endDate) {
		return hitzorduakRepository.findBySortzeDataBetween(startDate, endDate);
	}

	public Hitzorduak saveHitzorduak(Hitzorduak hitzorduak) {
	    return hitzorduakRepository.save(hitzorduak);
	}
	
	// ESTA_1:
	public List<Hitzorduak> getAppointmentsByDate(Date date) {
		return hitzorduakRepository.findBySortzeData(date);
	}
	
	// ESTA_2:
    public List<Hitzorduak> getAppointmentsByDate(String date) {
        try {
            Date parsedDate = Date.valueOf(date);
            System.out.println("Fecha pasada al repositorio: " + parsedDate);

            return hitzorduakRepository.findBySortzeData(parsedDate);
        } catch (IllegalArgumentException e) {
            System.err.println("Formato de fecha inválido: " + date);
            throw new RuntimeException("Formato de fecha inválido: " + date);
        }
    }
}
