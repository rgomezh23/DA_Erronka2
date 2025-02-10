package eus.fpsanturtzilh;


import eus.fpsanturtzilh.models.*;
import eus.fpsanturtzilh.repositories.*;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.Optional;
import jakarta.transaction.Transactional;

@Component
@Transactional
public class DB {

	private final ErabiltzaileRepository repository;
	private final TaldeakRepository taldeakRepository;
	private final MaterialakRepository materialakRepository;
	private final ZerbitzuakRepository zerbitzuakRepository;
	private final KategoriakRepository kategoriakRepository;
	private final BezeroFitxakRepository bezeroFitxakRepository;
	private final OrdutegiakRepository ordutegiakRepository;
	private final LangileakRepository langileakRepository;
	private final TxandakRepository txandakRepository;
	private final MaterialMaileguakRepository materialMaileguakRepository;
	private final HitzorduakRepository hitzorduakRepository;
	private final TicketLerroakRepository ticketLerroakRepository;
	//private final ProduktuakRepository produktuakReposiry;to
	private final KoloreHistorialakRepository koloreHistorialakRepository;
	private final ProduktuMugimenduakRepository produktuMugimenduakRepository;

	// Cosas.
	public DB(ErabiltzaileRepository repository, TaldeakRepository taldeakRepository,
			MaterialakRepository materialakRepository, ZerbitzuakRepository zerbitzuakRepository,
			KategoriakRepository kategoriakRepository, BezeroFitxakRepository bezeroFitxakRepository,
			OrdutegiakRepository ordutegiakRepository, LangileakRepository langileakRepository,
			TxandakRepository txandakRepository, MaterialMaileguakRepository materialMaileguakRepository,
			HitzorduakRepository hitzorduakRepository, TicketLerroakRepository ticketLerroakRepository,
			ProduktuMugimenduakRepository produktuMugimenduakRepository) {
		this.repository = repository;
		this.taldeakRepository = taldeakRepository;
		this.materialakRepository = materialakRepository;
		this.zerbitzuakRepository = zerbitzuakRepository;
		this.kategoriakRepository = kategoriakRepository;
		this.bezeroFitxakRepository = bezeroFitxakRepository;
		this.ordutegiakRepository = ordutegiakRepository;
		this.langileakRepository = langileakRepository;
		this.txandakRepository = txandakRepository;
		this.materialMaileguakRepository = materialMaileguakRepository;
		this.hitzorduakRepository = hitzorduakRepository;
		this.ticketLerroakRepository = ticketLerroakRepository;
		this.koloreHistorialakRepository = null;
		//this.produktuakRepository = produktuakRepository;
		this.produktuMugimenduakRepository = produktuMugimenduakRepository;
	}

	// ERABILTZAILEAK:
	public void erabiltzaileak_Insert(String izena, String pasahitza, String rola) {
		Date fecha = new Date(System.currentTimeMillis());

		Data data = new Data();
		data.setSortze_data(fecha);
		data.setEguneratze_data(null);
		data.setEzabatze_data(null);

		Erabiltzaile erabiltzaile = new Erabiltzaile();
		erabiltzaile.setUsername(izena);
		erabiltzaile.setPasahitza(pasahitza);
		erabiltzaile.setRola(rola);
		erabiltzaile.setData(data);

		repository.save(erabiltzaile);
		System.out.println("Erabiltzaile berria: " + erabiltzaile.getUsername());
	}

	public void erabiltzaileak_Update(Erabiltzaile erabiltzaileBerria) {
		Optional<Erabiltzaile> aa = repository.findById(erabiltzaileBerria.getUsername());

		if (aa.isPresent()) {
			Erabiltzaile user = aa.get();
			user.setPasahitza(erabiltzaileBerria.getPasahitza());
			user.setRola(erabiltzaileBerria.getRola());
			Date fecha = new Date(System.currentTimeMillis());
			user.getData().setEguneratze_data(fecha);
			repository.save(user);

			System.out.println("Erabiltzailea eguneratuta: " + user.getUsername());
		} else {
			System.out.println("Ez da erabiltzailea aurkitu: " + erabiltzaileBerria.getUsername());
		}
	}

	public void erabiltzaileak_Delete(String izena) {
		Optional<Erabiltzaile> aa = repository.findById(izena);

		if (aa.isPresent()) {
			Erabiltzaile user = aa.get();
			repository.delete(user);
			System.out.println("Erabiltzailea ezabatuta: " + izena);
		} else {
			System.out.println("Ez da erabiltzailea aurkitu: " + izena);
		}
	}

	public Erabiltzaile erabiltzaileak_Select(String izena) {
		Optional<Erabiltzaile> aa = repository.findById(izena);

		if (aa.isPresent()) {
			Erabiltzaile user = aa.get();
			return user;
		} else {
			System.out.println("Ez da erabiltzailea aurkitu: " + izena);
			return null;
		}
	}

	// TALDEAK:
	public void taldeak_Insert(String kodea, String izena) {
		Date fecha = new Date(System.currentTimeMillis());
		Data data = new Data();
		data.setSortze_data(fecha);
		data.setEguneratze_data(null);
		data.setEzabatze_data(null);

		Taldeak talde = new Taldeak();
		talde.setKodea(kodea);
		talde.setIzena(izena);
		talde.setData(data);

		taldeakRepository.save(talde);
		System.out.println("Taldea sortu da: " + talde.getKodea());
	}

	public void taldeak_Update(Taldeak taldeBerria) {
		Optional<Taldeak> aa = taldeakRepository.findById(taldeBerria.getKodea());

		if (aa.isPresent()) {
			Taldeak talde = aa.get();
			talde.setIzena(taldeBerria.getIzena());
			Date data = new Date(System.currentTimeMillis());
			talde.getData().setEguneratze_data(data);
			taldeakRepository.save(talde);

			System.out.println("Taldea eguneratuta: " + talde.getKodea());
		} else {
			System.out.println("Ez da taldea aurkitu: " + taldeBerria.getKodea());
		}
	}

	public void taldeak_Delete(String kodea) {
		Optional<Taldeak> aa = taldeakRepository.findById(kodea);

		if (aa.isPresent()) {
			Taldeak talde = aa.get();
			taldeakRepository.delete(talde);
			System.out.println("Taldea ezabatuta: " + kodea);
		} else {
			System.out.println("Ez da taldea aurkitu: " + kodea);
		}
	}

	public Taldeak taldeak_Select(String kodea) {
		Optional<Taldeak> aa = taldeakRepository.findById(kodea);
		if (aa.isPresent()) {
			Taldeak talde = aa.get();
			return talde;
		} else {
			System.out.println("Ez da taldea aurkitu: " + kodea);
			return null;
		}
	}

	// MATERIALAK:
	public void materialak_Insert(String etiketa, String izena) {
		Date fecha = new Date(System.currentTimeMillis());
		Data data = new Data();
		data.setSortze_data(fecha);
		data.setEguneratze_data(null);
		data.setEzabatze_data(null);

		Materialak materiala = new Materialak();
		materiala.setEtiketa(etiketa);
		materiala.setIzena(izena);
		materiala.setData(data);

		materialakRepository.save(materiala);
		System.out.println("Materiala sortu da: " + materiala.getEtiketa());
	}

	/**
	public void materialak_Update(Materialak materialBerria) {
		Optional<Materialak> aa = materialakRepository.findById(materialBerria.getId());

		if (aa.isPresent()) {
			Materialak materiala = aa.get();
			materiala.setEtiketa(materialBerria.getEtiketa());
			materiala.setIzena(materialBerria.getIzena());

			Date data = new Date(System.currentTimeMillis());
			materiala.getData().setEguneratze_data(data);
			materialakRepository.save(materiala);
			System.out.println("Materiala eguneratuta: " + materialBerria.getId());
		} else {
			System.out.println("Ez da materiala aurkitu: " + materialBerria.getId());
		}
	}
*
	public void materialak_Delete(int id) {
		Optional<Materialak> aa = materialakRepository.findById((long) id);

		if (aa.isPresent()) {
			Materialak materiala = aa.get();
			materialakRepository.delete(materiala);
			System.out.println("Materiala ezabatuta: " + id);
		} else {
			System.out.println("Ez da materiala aurkitu: " + id);
		}
	}

	public Materialak materialak_Select(int id) {
		Optional<Materialak> aa = materialakRepository.findById((long) id);

		if (aa.isPresent()) {
			Materialak material = aa.get();
			return material;
		} else {
			System.out.println("Ez da materiala aurkitu: " + id);
			return null;
		}
	}
*/
	// ZERBITZUAK:
	public void zerbitzuak_Insert(String izena, double etxekoPrezioa, double kanpokoPrezioa) {
		Date fecha = new Date(System.currentTimeMillis());
		Data data = new Data();
		data.setSortze_data(fecha);
		data.setEguneratze_data(null);
		data.setEzabatze_data(null);

		Zerbitzuak zerbitzua = new Zerbitzuak();
		zerbitzua.setIzena(izena);
		zerbitzua.setEtxeko_prezioa(etxekoPrezioa);
		zerbitzua.setKanpoko_prezioa(kanpokoPrezioa);
		zerbitzua.setData(data);

		zerbitzuakRepository.save(zerbitzua);
		System.out.println("Zerbitzua sortu da: " + zerbitzua.getIzena());
	}

	public void zerbitzuak_Update(Zerbitzuak zerbitzuBerria) {
		Optional<Zerbitzuak> aa = zerbitzuakRepository.findById(zerbitzuBerria.getId());

		if (aa.isPresent()) {
			Zerbitzuak zerbitzua = aa.get();
			zerbitzua.setIzena(zerbitzuBerria.getIzena());
			zerbitzua.setEtxeko_prezioa(zerbitzuBerria.getEtxeko_prezioa());
			zerbitzua.setKanpoko_prezioa(zerbitzuBerria.getKanpoko_prezioa());

			Date data = new Date(System.currentTimeMillis());
			zerbitzua.getData().setEguneratze_data(data);
			zerbitzuakRepository.save(zerbitzua);
			System.out.println("Zerbitzua eguneratuta: " + zerbitzua.getId());
		} else {
			System.out.println("Ez da zerbitzua aurkitu: " + zerbitzuBerria.getId());
		}
	}

	public void zerbitzuak_Delete(int id) {
		Optional<Zerbitzuak> aa = zerbitzuakRepository.findById(id);
		if (aa.isPresent()) {
			Zerbitzuak zerbitzua = aa.get();
			zerbitzuakRepository.delete(zerbitzua);
			System.out.println("Zerbitzua ezabatuta: " + id);
		} else {
			System.out.println("Ez da zerbitzua aurkitu: " + id);
		}
	}

	public Zerbitzuak zerbitzuak_Select(int id) {
		Optional<Zerbitzuak> aa = zerbitzuakRepository.findById(id);

		if (aa.isPresent()) {
			Zerbitzuak zerbitzua = aa.get();
			return zerbitzua;
		} else {
			System.out.println("Ez da zerbitzua aurkitu: " + id);
			return null;
		}
	}

	// KATEGORIAK:
	public void kategoriak_Insert(String izena) {
		Date fecha = new Date(System.currentTimeMillis());
		Data data = new Data();
		data.setSortze_data(fecha);
		data.setEguneratze_data(null);
		data.setEzabatze_data(null);

		Kategoriak kategoria = new Kategoriak();
		kategoria.setIzena(izena);
		kategoria.setData(data);

		kategoriakRepository.save(kategoria);
		System.out.println("Kategoria sortu da: " + kategoria.getIzena());
	}

	public void kategoriak_Update(Kategoriak kategoriaBerria) {
		Optional<Kategoriak> aa = kategoriakRepository.findById(kategoriaBerria.getId());

		if (aa.isPresent()) {
			Kategoriak kategoria = aa.get();
			kategoria.setIzena(kategoriaBerria.getIzena());
			Date data = new Date(System.currentTimeMillis());
			kategoria.getData().setEguneratze_data(data);
			kategoriakRepository.save(kategoria);
			System.out.println("Kategoria eguneratuta: " + kategoria.getId());
		} else {
			System.out.println("Ez da kategoria aurkitu: " + kategoriaBerria.getId());
		}
	}

	public void kategoriak_Delete(int id) {
		Optional<Kategoriak> aa = kategoriakRepository.findById(id);
		if (aa.isPresent()) {
			Kategoriak kategoria = aa.get();
			kategoriakRepository.delete(kategoria);
			System.out.println("Kategoria ezabatuta: " + id);
		} else {
			System.out.println("Ez da kategoria aurkitu: " + id);
		}
	}

	public Kategoriak kategoriak_Select(int id) {
		Optional<Kategoriak> aa = kategoriakRepository.findById(id);
		if (aa.isPresent()) {
			Kategoriak kategoria = aa.get();
			return kategoria;
		} else {
			System.out.println("Ez da kategoria aurkitu: " + id);
			return null;
		}
	}

	// BEZERO_FITXAK:
	public void bezero_fitxak_Insert(String izena, String abizena, String telefonoa, boolean azal_sentikorra) {
		Date fecha = new Date(System.currentTimeMillis());
		Data data = new Data();
		data.setSortze_data(fecha);
		data.setEguneratze_data(null);
		data.setEzabatze_data(null);

		Bezero_fitxak bezero_F = new Bezero_fitxak();
		bezero_F.setIzena(izena);
		bezero_F.setAbizena(abizena);
		bezero_F.setTelefonoa(telefonoa);
		bezero_F.setAzal_sentikorra(azal_sentikorra ? "B" : "E");
		bezero_F.setData(data);

		bezeroFitxakRepository.save(bezero_F);
		System.out.println("Bezero fitxa sortu da: " + bezero_F.getIzena() + " " + bezero_F.getAbizena());
	}

	public void bezero_fitxak_Update(Bezero_fitxak bezeroBerria) {
		Optional<Bezero_fitxak> aa = bezeroFitxakRepository.findById(bezeroBerria.getId());

		if (aa.isPresent()) {
			Bezero_fitxak bezero = aa.get();

			bezero.setIzena(bezeroBerria.getIzena());
			bezero.setAbizena(bezeroBerria.getAbizena());
			bezero.setTelefonoa(bezeroBerria.getTelefonoa());
			bezero.setAzal_sentikorra(bezeroBerria.getAzal_sentikorra());

			Date data = new Date(System.currentTimeMillis());
			bezero.getData().setEguneratze_data(data);

			bezeroFitxakRepository.save(bezero);
			System.out.println("Bezero fitxa eguneratuta: " + bezero.getId());
		} else {
			System.out.println("Ez da bezero fitxa aurkitu: " + bezeroBerria.getId());
		}
	}

	public void bezero_fitxak_Delete(long id) {
		Optional<Bezero_fitxak> bezeroOpt = bezeroFitxakRepository.findById(id);
		if (bezeroOpt.isPresent()) {
			Bezero_fitxak bezero = bezeroOpt.get();
			bezeroFitxakRepository.delete(bezero);
			System.out.println("Bezero fitxa ezabatuta: " + id);
		} else {
			System.out.println("Ez da bezero fitxa aurkitu: " + id);
		}
	}

	public Bezero_fitxak bezero_fitxak_Select(long id) {
		Optional<Bezero_fitxak> aa = bezeroFitxakRepository.findById(id);
		if (aa.isPresent()) {
			Bezero_fitxak bezero = aa.get();
			return bezero;
		} else {
			System.out.println("Ez da bezero fitxa aurkitu: " + id);
			return null;
		}
	}

	// Comienzan dependencias.

	// ORDUTEGIAK:
	public void ordutegiak_Insert(String kodea, int eguna, Date hasieraData, Date amaieraData, Time hasieraOrdua,
			Time amaieraOrdua) {
		Date fecha = new Date(System.currentTimeMillis());
		Data data = new Data();
		data.setSortze_data(fecha);
		data.setEguneratze_data(null);
		data.setEzabatze_data(null);
		Denbora denbora = new Denbora(hasieraOrdua, amaieraOrdua);

		Ordutegiak ordutegia = new Ordutegiak();
		ordutegia.setKodea(kodea);
		ordutegia.setEguna(eguna);
		ordutegia.setHasiera_data(hasieraData);
		ordutegia.setAmaiera_data(amaieraData);
		ordutegia.setData(data);
		ordutegia.setDenbora(denbora);

		ordutegiakRepository.save(ordutegia);
		System.out.println("Ordutegia sortu da: " + ordutegia.getId());
	}

	public void ordutegiak_Update(Ordutegiak ordutegiBerria) {
		Optional<Ordutegiak> aa = ordutegiakRepository.findById(ordutegiBerria.getId());

		if (aa.isPresent()) {
			Ordutegiak ordutegia = aa.get();
			Denbora denbora = new Denbora(ordutegiBerria.getDenbora().getHasiera_ordua(),
					ordutegiBerria.getDenbora().getAmaiera_ordua());

			ordutegia.setKodea(ordutegiBerria.getKodea());
			ordutegia.setEguna(ordutegiBerria.getEguna());
			ordutegia.setHasiera_data(ordutegiBerria.getHasiera_data());
			ordutegia.setAmaiera_data(ordutegiBerria.getAmaiera_data());
			ordutegia.setDenbora(denbora);

			Date fecha = new Date(System.currentTimeMillis());
			ordutegia.getData().setEguneratze_data(fecha);
			ordutegiakRepository.save(ordutegia);
			System.out.println("Ordutegia eguneratuta: " + ordutegia.getId());
		} else {
			System.out.println("Ez da ordutegia aurkitu: " + ordutegiBerria.getId());
		}
	}

	public void ordutegiak_Delete(int id) {
		Optional<Ordutegiak> aa = ordutegiakRepository.findById(id);

		if (aa.isPresent()) {
			Ordutegiak ordutegia = aa.get();
			ordutegiakRepository.delete(ordutegia);
			System.out.println("Ordutegia ezabatuta: " + id);
		} else {
			System.out.println("Ez da ordutegia aurkitu: " + id);
		}
	}

	public Ordutegiak ordutegiak_Select(int id) {
		Optional<Ordutegiak> aa = ordutegiakRepository.findById(id);
		if (aa.isPresent()) {
			Ordutegiak ordutegia = aa.get();
			return ordutegia;
		} else {
			System.out.println("Ez da ordutegia aurkitu: " + id);
			return null;
		}
	}

	// LANGILEAK:
	public void langileak_Insert(String izena, String kodea, String abizenak) {
		Date fecha = new Date(System.currentTimeMillis());
		Data data = new Data();
		data.setSortze_data(fecha);
		data.setEguneratze_data(null);
		data.setEzabatze_data(null);

		Langileak langilea = new Langileak();
		langilea.setIzena(izena);
		langilea.setKode(kodea);
		langilea.setAbizenak(abizenak);
		langilea.setData(data);

		langileakRepository.save(langilea);
		System.out.println("Langilea sortu da: " + langilea.getIzena());
	}

	public void langileak_Update(Langileak langileaBerria) {
		Optional<Langileak> aa = langileakRepository.findById(langileaBerria.getId());

		if (aa.isPresent()) {
			Langileak langilea = aa.get();
			langilea.setIzena(langileaBerria.getIzena());
			langilea.setAbizenak(langileaBerria.getAbizenak());

			Date data = new Date(System.currentTimeMillis());
			langilea.getData().setEguneratze_data(data);
			langileakRepository.save(langilea);
			System.out.println("Langilea eguneratuta: " + langilea.getId());
		} else {
			System.out.println("Ez da langilea aurkitu: " + langileaBerria.getId());
		}
	}

	public void langileak_Delete(int id) {
		Optional<Langileak> aa = langileakRepository.findById(id);
		if (aa.isPresent()) {
			Langileak langilea = aa.get();
			langileakRepository.delete(langilea);
			System.out.println("Langilea ezabatuta: " + id);
		} else {
			System.out.println("Ez da langilea aurkitu: " + id);
		}
	}

	public Langileak langileak_Select(int id) {
		Optional<Langileak> aa = langileakRepository.findById(id);
		if (aa.isPresent()) {
			Langileak langilea = aa.get();
			return langilea;
		} else {
			System.out.println("Ez da langilea aurkitu: " + id);
			return null;
		}
	}

	// TXANDAK:
	public void txandak_Insert(char mota, Date dataa, int langileakId) {
		Optional<Langileak> aa = langileakRepository.findById(langileakId);

		if (aa.isPresent()) {
			Langileak langilea = aa.get();
			Date fecha = new Date(System.currentTimeMillis());
			Data data = new Data();
			data.setSortze_data(fecha);
			data.setEguneratze_data(null);
			data.setEzabatze_data(null);

			Txandak txanda = new Txandak();
			txanda.setMota(mota);
			txanda.setData(dataa);
			txanda.setLangileak(langilea);
			txanda.setDataSimple(data);

			txandakRepository.save(txanda);
			System.out.println("Txanda sortu da: " + txanda.getId());
		} else {
			System.out.println("Ez da langilea aurkitu: " + langileakId);
		}
	}

	public void txandak_Update(Txandak txanda) {
		Optional<Txandak> aa = txandakRepository.findById(txanda.getId());

		if (aa.isPresent()) {
			Txandak updateatzeko = aa.get();
			updateatzeko.setMota(txanda.getMota());
			updateatzeko.setData(txanda.getData());
			updateatzeko.setLangileak(txanda.getLangileak());
			Date fecha = new Date(System.currentTimeMillis());
			updateatzeko.getDataSimple().setEguneratze_data(fecha);

			txandakRepository.save(updateatzeko);
			System.out.println("Txanda eguneratuta: " + txanda.getId());
		} else {
			System.out.println("Ez da txanda aurkitu: " + txanda.getId());
		}
	}

	public void txandak_Delete(int id) {
		Optional<Txandak> aa = txandakRepository.findById(id);
		if (aa.isPresent()) {
			Txandak txanda = aa.get();
			txandakRepository.delete(txanda);
			System.out.println("Txanda ezabatuta: " + id);
		} else {
			System.out.println("Ez da txanda aurkitu: " + id);
		}
	}

	public Txandak txandak_Select(int id) {
		Optional<Txandak> aa = txandakRepository.findById(id);
		if (aa.isPresent()) {
			Txandak txanda = aa.get();
			return txanda;
		} else {
			System.out.println("Ez da txanda aurkitu: " + id);
			return null;
		}
	}

	// MATERIAL_MAILEGUAK:
	/**
	public void material_mailegua_Insert(int idMateriala, int idLangilea, Date hasieraData, Date amaieraData) {
		Date dataa = new Date(System.currentTimeMillis());
		Data data = new Data();
		data.setSortze_data(dataa);
		data.setEguneratze_data(null);
		data.setEzabatze_data(null);

		Material_maileguak materialMailegua = new Material_maileguak();
		materialMailegua.setHasieraData(hasieraData);
		materialMailegua.setAmaieraData(amaieraData);

		Materialak material = materialakRepository.findById((long) idMateriala)
				.orElseThrow(() -> new RuntimeException("Material no encontrado"));
		Langileak langilea = langileakRepository.findById(idLangilea)
				.orElseThrow(() -> new RuntimeException("Langilea no encontrado"));

		materialMailegua.setMateriala(material);
		materialMailegua.setLangilea(langilea);
		materialMailegua.setData(data);

		materialMaileguakRepository.save(materialMailegua);
		System.out.println("Material mailegua sortu da: " + materialMailegua.getId());
	}
	*/

	public void material_mailegua_Update(Material_maileguak materialMailegua) {
		Material_maileguak updateatzeko = materialMaileguakRepository.findById(materialMailegua.getId()).orElseThrow(
				() -> new RuntimeException("Material mailegua ez da aurkitu: " + materialMailegua.getId()));

		updateatzeko.setHasieraData(materialMailegua.getHasieraData());
		updateatzeko.setAmaieraData(materialMailegua.getAmaieraData());
		updateatzeko.setIdLangilea(materialMailegua.getIdLangilea());
		updateatzeko.setMateriala(materialMailegua.getMateriala());

		Date fechaActual = new Date(System.currentTimeMillis());
		updateatzeko.getData().setEguneratze_data(fechaActual);

		materialMaileguakRepository.save(updateatzeko);
		System.out.println("Material mailegua eguneratuta: " + materialMailegua.getId());
	}

	public Material_maileguak material_mailegua_Select(int id) {
		Material_maileguak materialMailegua = materialMaileguakRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Material mailegua ez da aurkitu: " + id));
		return materialMailegua;
	}

	public void material_mailegua_Delete(int id) {
		Optional<Material_maileguak> aa = materialMaileguakRepository.findById(id);
		if (aa.isPresent()) {
			Material_maileguak material_mailegua = aa.get();
			materialMaileguakRepository.delete(material_mailegua);
			System.out.println("Ezabatuta: " + id);
		} else {
			System.out.println("Ez da aurkitu: " + id);
		}
	}

	// HITZORDUAK:
	public void hitzorduak_Insert(int eserlekua, Date data, Time hasiera_ordua, Time amaiera_ordua, String izena,
			String telefonoa, String deskribapena, char etxekoa, BigDecimal prezio_totala, Langileak langileak) {

		Date fecha = new Date(System.currentTimeMillis());
		Data dataa = new Data();
		dataa.setSortze_data(fecha);
		dataa.setEguneratze_data(null);
		dataa.setEzabatze_data(null);

		Hitzorduak hitzordua = new Hitzorduak();
		hitzordua.setDataSimple(dataa);
		hitzordua.setEserlekua(eserlekua);
		hitzordua.setData(data);
		hitzordua.setHasiera_ordua(hasiera_ordua);
		hitzordua.setAmaiera_ordua(amaiera_ordua);
		hitzordua.setIzena(izena);
		hitzordua.setTelefonoa(telefonoa);
		hitzordua.setDeskribapena(deskribapena);
		hitzordua.setEtxekoa(etxekoa);
		hitzordua.setPrezio_totala(prezio_totala);
		//hitzordua.setLangileak(langileak);

		hitzorduakRepository.save(hitzordua);
		System.out.println("Hitzordua sortu da: " + hitzordua.getIzena());
	}

	public void hitzorduak_Update(Hitzorduak hitzorduaBerria) {
		Optional<Hitzorduak> aa = hitzorduakRepository.findById(hitzorduaBerria.getId());
		if (aa.isPresent()) {
			Hitzorduak hitzordua = aa.get();

			hitzordua.setEserlekua(hitzorduaBerria.getEserlekua());
			hitzordua.setData(hitzorduaBerria.getData());
			hitzordua.setHasiera_ordua(hitzorduaBerria.getHasiera_ordua());
			hitzordua.setAmaiera_ordua(hitzorduaBerria.getAmaiera_ordua());
			hitzordua.setHasiera_ordua_erreala(hitzorduaBerria.getHasiera_ordua_erreala());
			hitzordua.setAmaiera_ordua_erreala(hitzorduaBerria.getAmaiera_ordua_erreala());
			hitzordua.setIzena(hitzorduaBerria.getIzena());
			hitzordua.setTelefonoa(hitzorduaBerria.getTelefonoa());
			hitzordua.setDeskribapena(hitzorduaBerria.getDeskribapena());
			hitzordua.setEtxekoa(hitzorduaBerria.getEtxekoa());
			hitzordua.setPrezio_totala(hitzorduaBerria.getPrezio_totala());
			//hitzordua.setLangileak(hitzorduaBerria.getLangileak());
			hitzordua.setDataSimple(hitzorduaBerria.getDataSimple());

			hitzordua.getDataSimple().setEguneratze_data(new Date(System.currentTimeMillis()));
			hitzorduakRepository.save(hitzordua);
			System.out.println("Eguneratuta: " + hitzordua);
		} else {
			System.out.println("Ez da aurkitu: " + hitzorduaBerria.getId());
		}
	}

	public void hitzorduak_Delete(int id) {
		try {
			hitzorduakRepository.deleteById(id);
			System.out.println("Ezabatuta.");
		} catch (EmptyResultDataAccessException e) {
			System.out.println("Errorea.");
		}
	}

	public Hitzorduak hitzorduak_Select(int id) {
		Optional<Hitzorduak> aa = hitzorduakRepository.findById(id);

		if (aa.isPresent()) {
			Hitzorduak hitzordua = aa.get();
			return hitzordua;
		} else {
			System.out.println("ID-a ez dago datu basean.");
			return null;
		}
	}

	// TICKET_LERROAK:
	public void ticket_lerroak_Insert(Hitzorduak hitzordua, Zerbitzuak zerbitzua, BigDecimal prezioa) {
		Date fecha = new Date(System.currentTimeMillis());
		Data data = new Data();
		data.setSortze_data(fecha);
		data.setEguneratze_data(null);
		data.setEzabatze_data(null);

		Ticket_lerroak ticket = new Ticket_lerroak();
		ticket.setHitzorduak(hitzordua);
		ticket.setZerbitzuak(zerbitzua);
		ticket.setPrezioa(prezioa);
		ticket.setData(data);

		ticketLerroakRepository.save(ticket);
		System.out.println("Ticket lerroa sortu da: " + ticket.getId());
	}

	public void ticket_lerroak_Update(Ticket_lerroak ticketLerroak) {
		Ticket_lerroak aa = ticketLerroakRepository.findById(ticketLerroak.getId()).orElse(null);

		if (aa != null) {
			aa.setHitzorduak(ticketLerroak.getHitzorduak());
			aa.setZerbitzuak(ticketLerroak.getZerbitzuak());
			aa.setPrezioa(ticketLerroak.getPrezioa());
			aa.setData(ticketLerroak.getData());
			aa.getData().setEguneratze_data(new Date(System.currentTimeMillis()));

			ticketLerroakRepository.save(aa);
			System.out.println("Ticket actualizado con éxito: " + aa.getId());
		} else {
			System.out.println("No se encontró el ticket con el ID proporcionado: " + ticketLerroak.getId());
		}
	}

	public void ticket_lerroak_Delete(int id) {
		if (ticketLerroakRepository.existsById(id)) {
			ticketLerroakRepository.deleteById(id);
			System.out.println("Ticket lerroa ezabatuta: " + id);
		} else {
			System.out.println("Ez da ticket lerroa aurkitu: " + id);
		}
	}

	public Ticket_lerroak ticket_lerroak_Select(int id) {
		Optional<Ticket_lerroak> aa = ticketLerroakRepository.findById(id);
		if (aa.isPresent()) {
			return aa.get();
		} else {
			System.out.println("No se encontró el ticket con ID: " + id);
			return null;
		}
	}
	
	/**
	// PRODUKTUAK:
	public void produktuak_Insert(String izena, String deskribapena, String marka, int stock, int stock_alerta,
			Kategoriak kategoriak) {
		Date fecha = new Date(System.currentTimeMillis());
		Data data = new Data();
		data.setSortze_data(fecha);
		data.setEguneratze_data(null);
		data.setEzabatze_data(null);

		Produktuak produktua = new Produktuak();
		produktua.setIzena(izena);
		produktua.setDeskribapena(deskribapena);
		produktua.setMarka(marka);
		produktua.setStock(stock);
		produktua.setStock_alerta(stock_alerta);
		produktua.setKategoriak(kategoriak);
		produktua.setData(data);

		produktuakRepository.save(produktua);
		System.out.println("Produktua sortuta: " + produktua.getId());
	}
	
	public void produktuak_Update(Produktuak produktua) {
		Optional<Produktuak> aa = produktuakRepository.findAll(produktua.getId());
		if (aa.isPresent()) {
			Produktuak updateatzeko = aa.get();

			updateatzeko.setIzena(produktua.getIzena());
			updateatzeko.setDeskribapena(produktua.getDeskribapena());
			updateatzeko.setMarka(produktua.getMarka());
			updateatzeko.setStock(produktua.getStock());
			updateatzeko.setStock_alerta(produktua.getStock_alerta());
			updateatzeko.setKategoriak(produktua.getKategoriak());
			updateatzeko.setData(produktua.getData());
			updateatzeko.getData().setEguneratze_data(new Date(System.currentTimeMillis()));

			produktuakRepository.save(updateatzeko);
			System.out.println("Produktua eguneratuta: " + updateatzeko.getId());
		} else {
			System.out.println("Ez da produktua aurkitu: " + produktua.getId());
		}
	}
	

	public void produktuak_Delete(int id) {
		Optional<Produktuak> aa = produktuakRepository.findById(id);

		if (aa.isPresent()) {
			produktuakRepository.deleteById(id);
			System.out.println("Produktua ezabatuta: " + id);
		} else {
			System.out.println("Ez da produktua aurkitu: " + id);
		}
	}

	public Produktuak produktuak_Select(int id) {
		Optional<Produktuak> optionalProducto = produktuakRepository.findById(id);

		if (optionalProducto.isPresent()) {
			return optionalProducto.get();
		} else {
			System.out.println("Ez da produktua aurkitu: " + id);
			return null;
		}
	}
	*/

	// KOLORE_HISTORIALAK:
	public void kolore_historialak_Insert(Bezero_fitxak bezero, Produktuak produktu, Date data, int kantitatea,
			String bolumena, String oharrak) {
		Date fecha = new Date(System.currentTimeMillis());
		Data dataa = new Data();
		dataa.setSortze_data(fecha);
		dataa.setEguneratze_data(null);
		dataa.setEzabatze_data(null);

		Kolore_historialak historiala = new Kolore_historialak();
		historiala.setBezero(bezero);
		// historiala.setProduktu(produktu);
		historiala.setData(data);
		historiala.setKantitatea(kantitatea);
		historiala.setBolumena(bolumena);
		historiala.setOharrak(oharrak);
		historiala.setDataSimple(dataa);

		koloreHistorialakRepository.save(historiala);
		System.out.println("Kolore historiala sortuta: " + historiala.getId());
	}

	public void kolore_historialak_Update(Kolore_historialak historialBerria) {
		Optional<Kolore_historialak> optionalHistoriala = koloreHistorialakRepository.findById(historialBerria.getId());

		if (optionalHistoriala.isPresent()) {
			Kolore_historialak updateatzeko = optionalHistoriala.get();
			updateatzeko.setBezero(historialBerria.getBezero());
			// updateatzeko.setProduktu(historialBerria.getProduktu());
			updateatzeko.setData(historialBerria.getData());
			updateatzeko.setKantitatea(historialBerria.getKantitatea());
			updateatzeko.setBolumena(historialBerria.getBolumena());
			updateatzeko.setOharrak(historialBerria.getOharrak());

			updateatzeko.setData(historialBerria.getData());
			updateatzeko.getDataSimple().setEguneratze_data(new Date(System.currentTimeMillis()));

			koloreHistorialakRepository.save(updateatzeko);
			System.out.println("Kolore historiala eguneratuta: " + historialBerria.getId());
		} else {
			System.out.println("Historiala ez da aurkitu IDarekin: " + historialBerria.getId());
		}
	}

	public void kolore_historialak_Delete(int id) {
		if (koloreHistorialakRepository.existsById(id)) {
			koloreHistorialakRepository.deleteById(id);
			System.out.println("Kolore historiala ezabatuta: " + id);
		} else {
			System.out.println("Historiala ez da aurkitu IDarekin: " + id);
		}
	}

	public Kolore_historialak kolore_historialak_Select(int id) {
		Optional<Kolore_historialak> aa = koloreHistorialakRepository.findById(id);

		if (aa.isPresent()) {
			return aa.get();
		} else {
			System.out.println("Historiala ez da aurkitu IDarekin: " + id);
			return null;
		}
	}

	// PRODUKTU_MUGIMENDUAK:
	public void produktu_mugimenduak_Insert(Produktuak produktua, Langileak langilea, double kopurua, Date data) {
		if (produktua != null && langilea != null) {
			Data dataa = new Data();
			Date fecha = new Date(System.currentTimeMillis());
			dataa.setSortze_data(fecha);
			dataa.setEguneratze_data(null);
			dataa.setEzabatze_data(null);

			Produktu_Mugimenduak mugimendua = new Produktu_Mugimenduak();
			mugimendua.setProduktuak(produktua);
			mugimendua.setLangilea(langilea);
			mugimendua.setKantitatea(kopurua);
			mugimendua.setData_Zutabea(data);

			mugimendua.setData(dataa);
			produktuMugimenduakRepository.save(mugimendua);

			System.out.println("Produktu mugimendu berria sortu da: " + mugimendua.getId());
		} else {
			System.out.println("Errorea: Produktua edo Langilea null da.");
		}
	}

	public void produktu_mugimenduak_Update(Produktu_Mugimenduak mugimenduBerria) {
		Optional<Produktu_Mugimenduak> aa = produktuMugimenduakRepository.findById(mugimenduBerria.getId());

		if (aa.isPresent()) {
			Produktu_Mugimenduak updateatzeko = aa.get();

			updateatzeko.setProduktuak(mugimenduBerria.getProduktuak());
			updateatzeko.setLangilea(mugimenduBerria.getLangilea());
			updateatzeko.setKantitatea(mugimenduBerria.getKantitatea());
			updateatzeko.setData_Zutabea(mugimenduBerria.getData_Zutabea());

			updateatzeko.getData().setEguneratze_data(new Date(System.currentTimeMillis()));
			produktuMugimenduakRepository.save(updateatzeko);
			System.out.println("Produktu mugimendu eguneratuta: " + mugimenduBerria.getId());
		} else {
			System.out.println("Produktu mugimendua ez da aurkitu IDarekin: " + mugimenduBerria.getId());
		}
	}

	public Produktu_Mugimenduak produktu_mugimenduak_Select(int id) {
		Optional<Produktu_Mugimenduak> aa = produktuMugimenduakRepository.findById(id);

		if (aa.isPresent()) {
			return aa.get();
		} else {
			System.out.println("Ez da produktua aurkitu: " + id);
			return null;
		}
	}

	public void produktu_mugimenduak_Delete(int id) {
		Optional<Produktu_Mugimenduak> aa = produktuMugimenduakRepository.findById(id);

		if (aa.isPresent()) {
			produktuMugimenduakRepository.deleteById(id);
			System.out.println("Produktu mugimendua ezabatua: " + id);
		} else {
			System.out.println("Produktu mugimendua ez da aurkitu IDarekin: " + id);
		}
	}

}

// Tener en cuenta que a la hora de borrar un usuario puede estar en un grupo.
// Estas cosas no están controladas, ya que tengo pensado hacer otras funciones que sean las que comprueben estas cosas.