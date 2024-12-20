package models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "kategoriak")
public class Kategoriak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String izena;
    
    @OneToMany(mappedBy = "kategoriak", cascade = CascadeType.ALL)
    private Produktuak produktuak;

    @Embedded
    private Data data;

	public Kategoriak() {}

	public Kategoriak(int id, String izena, Produktuak produktuak, Data data) {
		super();
		this.id = id;
		this.izena = izena;
		this.produktuak = produktuak;
		this.data = data;
	}

	public Produktuak getProduktuak() {
		return produktuak;
	}


	public void setProduktuak(Produktuak produktuak) {
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
