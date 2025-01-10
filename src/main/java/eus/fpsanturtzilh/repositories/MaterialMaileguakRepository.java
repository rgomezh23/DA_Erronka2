package eus.fpsanturtzilh.repositories;

import eus.fpsanturtzilh.models.Material_maileguak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialMaileguakRepository extends JpaRepository<Material_maileguak, Integer> {
}