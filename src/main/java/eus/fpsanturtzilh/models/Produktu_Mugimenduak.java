package eus.fpsanturtzilh.models;

import jakarta.persistence.*;

@Entity
@Table(name = "produktu_mugimenduak")
public class Produktu_Mugimenduak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "id_produktua", nullable = false)
    private Produktuak produktuak;
    
    private double kopurua;
    
    @Embedded
    Data data;
    
    
    @ManyToOne
    @JoinColumn(name = "id_langilea", nullable = false)
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


	public double getKantitatea() {
		return kopurua;
	}

	public void setKantitatea(double kopurua) {
		this.kopurua = kopurua;
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

	public Produktu_Mugimenduak() {}

	public Produktu_Mugimenduak(int id, Produktuak produktuak, String mota, double kantitatea, Data data,
			Langileak langilea) {
		super();
		this.id = id;
		this.produktuak = produktuak;
		this.kopurua = kantitatea;
		this.data = data;
		this.langilea = langilea;
	}
	
	
	
}
