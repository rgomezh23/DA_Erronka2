package eus.fpsanturtzilh.repositories;

import eus.fpsanturtzilh.models.Material_maileguak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialMaileguakRepository extends JpaRepository<Material_maileguak, Integer> {

    @Query("SELECT m FROM Material_maileguak m WHERE m.data.ezabatze_data IS NULL")
    List<Material_maileguak> findAllNotDeleted();  // Materiales no eliminados

    @Query("SELECT m FROM Material_maileguak m WHERE m.data.ezabatze_data IS NOT NULL")
    List<Material_maileguak> findAllDeleted();  // Materiales eliminados
}
