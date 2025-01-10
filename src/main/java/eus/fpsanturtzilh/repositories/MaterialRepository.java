package eus.fpsanturtzilh.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import eus.fpsanturtzilh.models.Materialak;


public interface MaterialRepository extends JpaRepository<Materialak,Long> {
	
	@EntityGraph(attributePaths = {"maileguak"}) //atributuaren izena modeloaren aldagaia
	List<Materialak> findAll();
}

