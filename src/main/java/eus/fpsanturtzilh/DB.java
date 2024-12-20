package eus.fpsanturtzilh;

import eus.fpsanturtzilh.models.Erabiltzaile;
import eus.fpsanturtzilh.models.Taldeak;
import eus.fpsanturtzilh.models.Data;
import eus.fpsanturtzilh.repositories.ErabiltzaileRepository;
import eus.fpsanturtzilh.repositories.TaldeakRepository;

import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Optional;

@Component
public class DB {

	private final ErabiltzaileRepository repository;
	private final TaldeakRepository taldeakRepository;

	public DB(ErabiltzaileRepository repository, TaldeakRepository taldeakRepository) {
		this.repository = repository;
		this.taldeakRepository = taldeakRepository;
	}

	// ERABILTZAILEAK:
	public void erabiltzailea_Sortu() {
		Date fecha = new Date(System.currentTimeMillis());

		Data data = new Data();
		data.setSortze_data(fecha);
		data.setEguneratze_data(fecha);
		data.setEzabatze_data(null);

		Erabiltzaile erabiltzaile = new Erabiltzaile();
		erabiltzaile.setUsername("A");
		erabiltzaile.setPasahitza("1234");
		erabiltzaile.setRola("Rola");
		erabiltzaile.setData(data);

		repository.save(erabiltzaile);
		System.out.println("Erabiltzaile berria: " + erabiltzaile.getUsername());
	}

	public void erabiltzailea_Eguneratu(String izena, String pasahitz_B, String rol_B) {
		Optional<Erabiltzaile> aa = repository.findById(izena);

		if (aa.isPresent()) {
			Erabiltzaile user = aa.get();

			user.setPasahitza(pasahitz_B);
			user.setRola(rol_B);

			Date fecha = new Date(System.currentTimeMillis());
			user.getData().setEguneratze_data(fecha);
			repository.save(user);

			System.out.println("Erabiltzailea eguneratuta: " + user.getUsername());
		} else {
			System.out.println("Ez da erabiltzailea aurkitu: " + izena);
		}
	}

	public void erabiltzailea_Ezabatu(String izena) {
		Optional<Erabiltzaile> aa = repository.findById(izena);

		if (aa.isPresent()) {
			Erabiltzaile user = aa.get();
			repository.delete(user);
			System.out.println("Erabiltzailea ezabatuta: " + izena);
		} else {
			System.out.println("Ez da erabiltzailea aurkitu: " + izena);
		}
	}

	// TALDEAK:
	public void taldea_Sortu() {
		Date fecha = new Date(System.currentTimeMillis());
		Data data = new Data();
		data.setSortze_data(fecha);
		data.setEguneratze_data(fecha);
		data.setEzabatze_data(null);

		Taldeak talde = new Taldeak();
		talde.setKodea("3PAG2");
		talde.setIzena("AAA");
		talde.setData(data);

		taldeakRepository.save(talde);

		System.out.println("Taldea sortu da: " + talde.getKodea());
	}

	public void taldea_Eguneratu(String kodea, String izen_B) {
		Optional<Taldeak> aa = taldeakRepository.findById(kodea);

		if (aa.isPresent()) {
			Taldeak talde = aa.get();
			talde.setIzena(izen_B);
			Date data = new Date(System.currentTimeMillis());
			talde.getData().setEguneratze_data(data);

			taldeakRepository.save(talde);

			System.out.println("Taldea eguneratuta: " + kodea);
		} else {
			System.out.println("Ez da taldea aurkitu: " + kodea);
		}
	}

	public void taldea_Ezabatu(String kodea) {
		Optional<Taldeak> aa = taldeakRepository.findById(kodea);

		if (aa.isPresent()) {
			Taldeak talde = aa.get();

			taldeakRepository.delete(talde);

			System.out.println("Taldea ezabatuta: " + kodea);
		} else {
			System.out.println("Ez da taldea aurkitu: " + kodea);
		}
	}
}

/**
 * Las operaciones CRUD no están hechas o no funcionan en estas tablas:
 * 
 * produktu_mugimenduak, kolore_historialak, bezero_fitxak, produktuak, kategoriak,
 * ticket_lerroak, zerbitzuak, hitzorduak, material_maileguak, materialak txandak,
 * langileak ordutegiak y taldeak
 */