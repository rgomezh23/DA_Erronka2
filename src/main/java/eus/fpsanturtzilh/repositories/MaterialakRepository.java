package eus.fpsanturtzilh.repositories;

import eus.fpsanturtzilh.models.Materialak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MaterialakRepository extends JpaRepository<Materialak, Integer> {

    Optional<Materialak> findById(Integer id);

    @Query("SELECT m FROM Materialak m WHERE m.data.ezabatze_data IS NULL")
    List<Materialak> findByDataEzabatze_DataIsNull();

    @Query("SELECT m FROM Materialak m WHERE m.data.ezabatze_data IS NOT NULL")
    List<Materialak> findByDataEzabatze_DataIsNotNull();

}
