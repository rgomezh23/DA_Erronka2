package eus.fpsanturtzilh.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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
	@JoinColumn(name = "id_kategoria", nullable = false)
	private Kategoriak kategoriak;

	@Embedded
	private Data data;
}
