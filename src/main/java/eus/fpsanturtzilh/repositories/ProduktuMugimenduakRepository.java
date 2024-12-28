package eus.fpsanturtzilh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import eus.fpsanturtzilh.models.Produktu_Mugimenduak;

@Repository
public interface ProduktuMugimenduakRepository extends JpaRepository<Produktu_Mugimenduak, Integer> {
}
