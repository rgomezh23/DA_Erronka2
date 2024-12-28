package eus.fpsanturtzilh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eus.fpsanturtzilh.models.Ordutegiak;

@Repository
public interface OrdutegiakRepository extends JpaRepository<Ordutegiak, Integer> {
}
