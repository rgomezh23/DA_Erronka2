package eus.fpsanturtzilh.repositories;

import eus.fpsanturtzilh.models.Txandak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TxandakRepository extends JpaRepository<Txandak, Integer> {
}