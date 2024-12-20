package Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.Erabiltzaile;
import repositories.ErabiltzaileRepository;

@Service
public class ErabiltzaileService {

    @Autowired
    private ErabiltzaileRepository erabiltzaileRepository;

    public Optional<Erabiltzaile> getErabiltzaileByUsername(String username) {
        return erabiltzaileRepository.findByUsername(username);
    }
}
