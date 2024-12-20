package eus.fpsanturtzilh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "eus.fpsanturtzilh.controllers") // Asegúrate de que este es el paquete correcto donde está tu controlador
public class DaErronka2Application {

    public static void main(String[] args) {
        SpringApplication.run(DaErronka2Application.class, args);
    }
}
