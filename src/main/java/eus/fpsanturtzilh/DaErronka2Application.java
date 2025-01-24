package eus.fpsanturtzilh;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = { "eus.fpsanturtzilh" })
public class DaErronka2Application implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(DaErronka2Application.class, args);
		System.out.println("Corriendo.");
	}

	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("http://localhost:8100")
				.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS").allowedHeaders("*").allowCredentials(true);
	}
}

// Para los langiles desplegables.