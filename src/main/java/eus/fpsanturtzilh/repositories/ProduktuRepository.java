package eus.fpsanturtzilh.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import eus.fpsanturtzilh.models.Produktuak;

public interface ProduktuRepository extends JpaRepository<Produktuak, Integer> {
    @EntityGraph(attributePaths = {"kategoriak"})
    List<Produktuak> findAll();
    Optional<Produktuak> findById(Integer id);
}
