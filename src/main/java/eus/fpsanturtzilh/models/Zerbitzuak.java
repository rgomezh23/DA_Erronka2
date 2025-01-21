 package eus.fpsanturtzilh.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "zerbitzuak")
public class Zerbitzuak {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String izena;
	private double etxeko_prezioa;
	private double kanpoko_prezioa;

	@Embedded
	Data data;
}
