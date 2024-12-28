package eus.fpsanturtzilh;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import eus.fpsanturtzilh.models.Bezero_fitxak;
import eus.fpsanturtzilh.models.Data;
import eus.fpsanturtzilh.models.Erabiltzaile;
import eus.fpsanturtzilh.models.Hitzorduak;
import eus.fpsanturtzilh.models.Kategoriak;
import eus.fpsanturtzilh.models.Kolore_historialak;
import eus.fpsanturtzilh.models.Langileak;
import eus.fpsanturtzilh.models.Material_maileguak;
import eus.fpsanturtzilh.models.Materialak;
import eus.fpsanturtzilh.models.Ordutegiak;
import eus.fpsanturtzilh.models.Produktu_Mugimenduak;
import eus.fpsanturtzilh.models.Produktuak;
import eus.fpsanturtzilh.models.Taldeak;
import eus.fpsanturtzilh.models.Ticket_lerroak;
import eus.fpsanturtzilh.models.Txandak;
import eus.fpsanturtzilh.models.Zerbitzuak;

@SpringBootApplication(scanBasePackages = "eus.fpsanturtzilh")
public class DaErronka2Application {

	public static void main(String[] args) {
		SpringApplication.run(DaErronka2Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(DB db) {
		return (args) -> {
			db.langileak_Delete(7);
		};
	}
}

// Date.valueOf("2024-01-15"), Time.valueOf("01:00:00"), new Date(System.currentTimeMillis());

// NOTAS A COMENTAR A RAÚL:
// En algunas tablas SQL, configura las fechas como le da la gana, no importa lo que se haga desde Java.
// Estas son: materialak / zerbitzuak / kategoriak / taldeak / txandak / hitzorduak / ticket_lerroak y todos los que le siguen.
