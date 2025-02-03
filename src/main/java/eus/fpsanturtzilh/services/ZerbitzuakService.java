package eus.fpsanturtzilh.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eus.fpsanturtzilh.models.Zerbitzuak;
import eus.fpsanturtzilh.repositories.ZerbitzuakRepository;

@Service
public class ZerbitzuakService {

    @Autowired
    private ZerbitzuakRepository zerbitzuRepository;

    public List<Zerbitzuak> getAllZerbitzuak() {
        return zerbitzuRepository.findAll();
    }

    public Zerbitzuak saveZerbitzuak(Zerbitzuak zerbitzuak) {
        return zerbitzuRepository.save(zerbitzuak); // Guardar un nuevo servicio
    }

    public Zerbitzuak updateZerbitzuak(Zerbitzuak zerbitzuak) {
        Optional<Zerbitzuak> zerbitzua = zerbitzuRepository.findById(zerbitzuak.getId());
        
        if (zerbitzua.isPresent()) {
            Zerbitzuak zerbitzuzaharra = zerbitzua.get();
            
            zerbitzuzaharra.setIzena(zerbitzuak.getIzena());
            zerbitzuzaharra.setEtxeko_prezioa(zerbitzuak.getEtxeko_prezioa());
            zerbitzuzaharra.setKanpoko_prezioa(zerbitzuak.getKanpoko_prezioa());
            if (zerbitzuak.getData() != null) {
                zerbitzuzaharra.setData(zerbitzuak.getData());
            }

            return zerbitzuRepository.save(zerbitzuzaharra);
        } else {
            throw new RuntimeException("Servicio no encontrado con ID: " + zerbitzuak.getId());
        }
    }

    // Método para eliminar un servicio
    public boolean deleteZerbitzuak(int id) {
        Optional<Zerbitzuak> zerbitzuak = zerbitzuRepository.findById(id);
        if (zerbitzuak.isPresent()) {
            zerbitzuRepository.delete(zerbitzuak.get());
            return true; // El servicio fue eliminado

        } else {
            return false; // No se encontró el servicio con ese ID
        }
    }
}
