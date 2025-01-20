package eus.fpsanturtzilh.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produktuak {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String izena;
	private String deskribapena;
	private String marka;
	private int stock;
	private int stock_alerta;

	@ManyToOne
	@JsonManagedReference(value="kategoriak-produktu")
	@JoinColumn(name = "id_kategoria", nullable = false)
	private Kategoriak kategoriak;

	@Embedded
	private Data data;
}

// Eliminado: Prezioa.