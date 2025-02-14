package eus.fpsanturtzilh.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;


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

	@Column(name = "id_produktua", nullable = false)
	private int produktuak;

	@Column(name = "kopurua")
	private double kantitatea;

	@Embedded
	private Data data;

	@Column(name = "id_langilea", nullable = false)
	private int langilea;

	@Column(name = "data", nullable = false)
	private Date data_Zutabea;

	@PrePersist
	public void prePersist() {
		if (data_Zutabea == null) {
			data_Zutabea = new Date(System.currentTimeMillis());
		}
	}
}
