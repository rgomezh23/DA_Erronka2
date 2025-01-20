package eus.fpsanturtzilh.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "produktu_mugimenduak")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produktu_Mugimenduak {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JsonManagedReference(value="Produktu_Mugimenduak-produktu")
	@JoinColumn(name = "id_produktua", nullable = false)
	private Produktuak produktuak;

	@Column(name = "kopurua")
	private double kantitatea;

	@Embedded
	private Data data;

	@ManyToOne
	@JoinColumn(name = "id_langilea", nullable = false)
	private Langileak langilea;

	@Column(name = "data", nullable = false)
	private Date data_Zutabea;

	@PrePersist // GPT-cosa
	public void prePersist() {
		if (data_Zutabea == null) {
			data_Zutabea = new Date(System.currentTimeMillis());
		}
	}
}

// Agregado: data_Zutabea para el SQL.