package eus.fpsanturtzilh.models;

import jakarta.persistence.*;

@Entity
@Table(name = "produktu_Mugimenduak")
public class Produktu_Mugimenduak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "id_produktua", nullable = false)
    private Produktuak produktuak;
    
    private String mota;
    private double kantitatea;
    
    @Embedded
    Data data;
    
    @ManyToOne
    @JoinColumn(name = "id_produktua")
    private Produktuak produktua;
    
    @ManyToOne
    @JoinColumn(name = "id_langilea")
    private Langileak langilea;

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

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
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
	
	public Produktuak getProduktua() {
		return produktua;
	}

	public void setProduktua(Produktuak produktua) {
		this.produktua = produktua;
	}

	public Langileak getLangilea() {
		return langilea;
	}

	public void setLangilea(Langileak langilea) {
		this.langilea = langilea;
	}

	public Produktu_Mugimenduak() {}
	
}
