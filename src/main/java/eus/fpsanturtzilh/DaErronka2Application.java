package eus.fpsanturtzilh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"eus.fpsanturtzilh.controllers", "eus.fpsanturtzilh.services", "eus.fpsanturtzilh.repositories", "eus.fpsanturtzilh.models", "eus.fpsanturtzilh.config"}) 
public class DaErronka2Application {

    public static void main(String[] args) {
        SpringApplication.run(DaErronka2Application.class, args);
    }
}
