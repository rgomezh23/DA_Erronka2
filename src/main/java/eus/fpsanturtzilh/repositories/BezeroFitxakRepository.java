package eus.fpsanturtzilh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eus.fpsanturtzilh.models.Bezero_fitxak;

@Repository
public interface BezeroFitxakRepository extends JpaRepository<Bezero_fitxak, Integer> {
}
