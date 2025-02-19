package eus.fpsanturtzilh.services;

import eus.fpsanturtzilh.models.Txandak;
import eus.fpsanturtzilh.repositories.TxandakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TxandakService {

	private final TxandakRepository txandakRepository;

	@Autowired
	public TxandakService(TxandakRepository txandakRepository) {
		this.txandakRepository = txandakRepository;
	}

	public List<Txandak> findAll() {
		return txandakRepository.findAll();
	}

	public Optional<Txandak> findById(int id) {
		return txandakRepository.findById(id);
	}

	public Txandak createTxandak(Txandak txandak) {
		return txandakRepository.save(txandak);
	}

	public Txandak updateTxandak(Txandak txandak) {
		return txandakRepository.save(txandak);
	}

	public void deleteTxandak(int id) {
		txandakRepository.deleteById(id);
	}

	public List<Txandak> findByDataEzabatzeDataIsNull() {
		return txandakRepository.findByDataEzabatzeDataIsNull();
	}

	public List<Txandak> findByDataEzabatzeDataIsNotNull() {
		return txandakRepository.findByDataEzabatzeDataIsNotNull();
	}

	public Txandak softDeleteTxandakById(int id) {
		Optional<Txandak> txandakOptional = txandakRepository.findById(id);

		if (txandakOptional.isPresent()) {
			Txandak txandak = txandakOptional.get();
			txandak.getDataSimple().setEzabatze_data(new Date(System.currentTimeMillis()));
			return txandakRepository.save(txandak);
		} else {
			throw new RuntimeException("Txandak ez da aurkitu: " + id);
		}
	}

	public void hardDeleteTxandakById(int id) {
		Optional<Txandak> txandakOptional = txandakRepository.findById(id);

		if (txandakOptional.isPresent()) {
			txandakRepository.deleteById(id);
		} else {
			throw new RuntimeException("Txandak ez da aurkitu: " + id);
		}
	}

}
