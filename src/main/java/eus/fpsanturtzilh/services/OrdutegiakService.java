package eus.fpsanturtzilh.services;

import eus.fpsanturtzilh.models.Ordutegiak;
import eus.fpsanturtzilh.repositories.OrdutegiakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrdutegiakService {

	@Autowired
	private OrdutegiakRepository ordutegiakRepository;

	public List<Ordutegiak> findAllNotDeleted() {
		return ordutegiakRepository.findAllNotDeleted();
	}

	public List<Ordutegiak> findAllDeleted() {
		return ordutegiakRepository.findAllDeleted();
	}

	public Optional<Ordutegiak> findById(int id) {
		return ordutegiakRepository.findById(id);
	}

	public Ordutegiak createNewOrdutegiak(Ordutegiak ordutegiak) {
		return ordutegiakRepository.save(ordutegiak);
	}

	public Ordutegiak updateOrdutegiak(Ordutegiak ordutegiak) {
		return ordutegiakRepository.save(ordutegiak);
	}

	public Ordutegiak softDelete(int id) {
		Optional<Ordutegiak> ordutegiak = ordutegiakRepository.findById(id);
		if (ordutegiak.isPresent()) {
			ordutegiak.get().getData().setEzabatze_data(new Date(System.currentTimeMillis()));
			return ordutegiakRepository.save(ordutegiak.get());
		} else {
			throw new RuntimeException("Ordutegiak not found");
		}
	}

	public void hardDelete(int id) {
		ordutegiakRepository.deleteById(id);
	}
}
