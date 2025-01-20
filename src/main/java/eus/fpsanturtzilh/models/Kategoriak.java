package eus.fpsanturtzilh.models;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

	@OneToMany(mappedBy = "kategoriak", cascade = CascadeType.ALL)
	@JsonBackReference(value="kategoriak-produktu")
	private List<Produktuak> produktuak;

	@Embedded
	private Data data;
}
