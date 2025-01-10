package eus.fpsanturtzilh.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "kategoriak")
public class Kategoriak {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String izena;

	@OneToMany(mappedBy = "kategoriak", cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Produktuak> produktuak;

	@Embedded
	private Data data;

	public Kategoriak() {
	}

	public Kategoriak(int id, String izena, List<Produktuak> produktuak, Data data) {
		this.id = id;
		this.izena = izena;
		this.produktuak = produktuak;
		this.data = data;
	}

	public List<Produktuak> getProduktuak() {
		return produktuak;
	}

	public void setProduktuak(List<Produktuak> produktuak) {
		this.produktuak = produktuak;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}
}
