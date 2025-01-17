package eus.fpsanturtzilh.models;

import jakarta.persistence.*;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "produktu_mugimenduak")
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Produktuak getProduktuak() {
		return produktuak;
	}

	public void setProduktuak(Produktuak produktuak) {
		this.produktuak = produktuak;
	}

	public double getKantitatea() {
		return kantitatea;
	}

	public void setKantitatea(double kantitatea) {
		this.kantitatea = kantitatea;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public Langileak getLangilea() {
		return langilea;
	}

	public void setLangilea(Langileak langilea) {
		this.langilea = langilea;
	}

	public Date getdata_Zutabea() {
		return data_Zutabea;
	}

	public void setdata_Zutabea(Date dataColumn) {
		this.data_Zutabea = dataColumn;
	}

	public Produktu_Mugimenduak() {
	}

	public Produktu_Mugimenduak(int id, Produktuak produktuak, double kantitatea, Data data, Langileak langilea,
			Date data_Zutabea) {
		super();
		this.id = id;
		this.produktuak = produktuak;
		this.kantitatea = kantitatea;
		this.data = data;
		this.langilea = langilea;
		this.data_Zutabea = data_Zutabea;
	}

	@PrePersist // GPT-cosa
	public void prePersist() {
		if (data_Zutabea == null) {
			data_Zutabea = new Date(System.currentTimeMillis());
		}
	}
}

// Agregado: data_Zutabea para el SQL.