package eus.fpsanturtzilh.repositories;

import eus.fpsanturtzilh.models.Produktuak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProduktuRepository extends JpaRepository<Produktuak, Integer> {
    
    // Consulta para obtener un producto por su ID
    Optional<Produktuak> findById(int id);

    // Consulta para obtener los productos que NO tienen fecha de eliminación (soft delete)
    @Query("SELECT p FROM Produktuak p WHERE p.data.ezabatze_data IS NULL")
    List<Produktuak> findAllNotDeleted();
    
    // Consulta para obtener los productos que tienen fecha de eliminación (soft delete)
    @Query("SELECT p FROM Produktuak p WHERE p.data.ezabatze_data IS NOT NULL")
    List<Produktuak> findAllDeleted();
}
