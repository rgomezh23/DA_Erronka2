package eus.fpsanturtzilh.models;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "kategoriak")
public class Kategoriak {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String izena;

	@Embedded
	private Data data;
}
