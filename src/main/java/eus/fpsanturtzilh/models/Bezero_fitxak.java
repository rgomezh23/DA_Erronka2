package eus.fpsanturtzilh.models;

import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bezero_fitxak")
public class Bezero_fitxak {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String izena;
	private String abizena;
	private String telefonoa;
	private String azal_sentikorra;

	@Embedded
	private Data data;

	@OneToMany(mappedBy = "bezero", cascade = CascadeType.ALL)
	private List<Kolore_historialak> historiala;

}
