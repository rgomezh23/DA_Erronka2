package eus.fpsanturtzilh.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

	@Column(name = "id_bezeroa", nullable = false)
	private int bezero; // El ID, no el objeto como tal.

	@Column(name = "id_produktua", nullable = false)
	private int produktu_id; // El ID, no el objeto como tal.

	private Date data;
	private int kantitatea;
	private String bolumena;
	private String oharrak;

	@Embedded
	private Data dataSimple;
}
