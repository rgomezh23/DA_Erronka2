package eus.fpsanturtzilh.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "materialak")
public class Materialak {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String etiketa;
	private String izena;

	@OneToMany(mappedBy = "materiala", cascade = CascadeType.ALL)
	private List<Material_maileguak> maileguak;

	public Materialak(int id, String etiketa, String izena, Data data) {
		super();
		this.id = id;
		this.etiketa = etiketa;
		this.izena = izena;
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEtiketa() {
		return etiketa;
	}

	public void setEtiketa(String etiketa) {
		this.etiketa = etiketa;
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

	@Embedded
	private Data data;

	public Materialak() {
	}
}
