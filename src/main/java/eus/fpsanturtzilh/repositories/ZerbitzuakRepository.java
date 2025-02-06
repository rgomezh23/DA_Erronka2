package eus.fpsanturtzilh.repositories;

import eus.fpsanturtzilh.models.Zerbitzuak;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZerbitzuakRepository extends JpaRepository<Zerbitzuak, Integer> {
	@EntityGraph(attributePaths = { "ticket_lerroak" })
	List<Zerbitzuak> findAll();

	Optional<Zerbitzuak> findById(int id);

}