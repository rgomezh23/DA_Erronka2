package Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Models.Erabiltzaile;
import Repositoty.ErabiltzaileRepository;

@Service
public class ErabiltzaileService {

    @Autowired
    private ErabiltzaileRepository erabiltzaileRepository;

    public boolean autentifikatu(String nombre, String password) {
        Erabiltzaile usuario = erabiltzaileRepository.findByIzena(nombre);
        
        if (usuario != null && usuario.getPasahitza().equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}
