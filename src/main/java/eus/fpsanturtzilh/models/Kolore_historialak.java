package eus.fpsanturtzilh.models;

import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "kolore_historialak")
public class Kolore_historialak {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "id_bezeroa", nullable = false)
	private Bezero_fitxak bezero;

	@ManyToOne
	@JsonManagedReference(value="Kolore_historialak-produktu")
	@JoinColumn(name = "id_produktua", nullable = false)
	private Produktuak produktu;
	private Date data;
	private int kantitatea;
	private String bolumena;
	private String oharrak;

	@Embedded
	private Data dataSimple;

}


