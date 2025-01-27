package eus.fpsanturtzilh.repositories;

import eus.fpsanturtzilh.models.Langileak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LangileakRepository extends JpaRepository<Langileak, Integer> {
	 @Query("SELECT MAX(l.id) FROM Langileak l")
	    Integer findMaxID();
}
