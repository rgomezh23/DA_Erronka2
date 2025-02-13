package eus.fpsanturtzilh.repositories;

import eus.fpsanturtzilh.models.Txandak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TxandakRepository extends JpaRepository<Txandak, Integer> {

    // Consultas corregidas para acceder a la propiedad "ezabatze_data" dentro de "Data"
    @Query("SELECT t FROM Txandak t WHERE t.dataSimple.ezabatze_data IS NULL")
    List<Txandak> findByDataEzabatzeDataIsNull();

    @Query("SELECT t FROM Txandak t WHERE t.dataSimple.ezabatze_data IS NOT NULL")
    List<Txandak> findByDataEzabatzeDataIsNotNull();
}
