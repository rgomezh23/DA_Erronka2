package eus.fpsanturtzilh.repositories;

import eus.fpsanturtzilh.models.Produktuak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduktuakRepository extends JpaRepository<Produktuak, Integer> {
	
}
