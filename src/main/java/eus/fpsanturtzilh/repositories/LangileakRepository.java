package eus.fpsanturtzilh.repositories;

import eus.fpsanturtzilh.models.Langileak;
import eus.fpsanturtzilh.models.Taldeak;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LangileakRepository extends JpaRepository<Langileak, Integer> {
	 
	 Optional<Taldeak> findByKode(String kodea);
}

