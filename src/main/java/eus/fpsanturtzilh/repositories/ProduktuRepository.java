package eus.fpsanturtzilh.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import eus.fpsanturtzilh.models.Produktuak;



public interface ProduktuRepository extends JpaRepository<Produktuak, Integer> {
    //Guztia bueltatu nahi bada ez da behar ezer egin.
}
