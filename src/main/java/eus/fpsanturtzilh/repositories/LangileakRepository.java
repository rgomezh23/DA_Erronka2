package eus.fpsanturtzilh.repositories;

import eus.fpsanturtzilh.models.Langileak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LangileakRepository extends JpaRepository<Langileak, Integer> {
}
