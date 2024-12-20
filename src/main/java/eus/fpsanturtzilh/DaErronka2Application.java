package eus.fpsanturtzilh;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DaErronka2Application {

    public static void main(String[] args) {
        SpringApplication.run(DaErronka2Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(DB db) {
        return (args) -> {
        	// ERABILTZAILEAK:
        	// db.erabiltzailea_Sortu();
            // db.erabiltzailea_Ezabatu("A");
        	// db.erabiltzailea_Eguneratu("A", "A", "A"); OJO: Mejorar esta movida.
        	
        	// A
        	// TALDEAK:
        	// db.taldea_Sortu();
        	// db.taldea_Eguneratu("3PAG2", "B");
        	// db.taldea_Ezabatu("3PAG2");
        };
    }
}
