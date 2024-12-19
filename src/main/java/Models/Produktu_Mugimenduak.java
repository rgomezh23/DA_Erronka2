package Models;

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

	public Produktu_Mugimenduak(int id, Produktuak produktuak, String mota, double kantitatea, Data data) {
		super();
		this.id = id;
		this.produktuak = produktuak;
		this.mota = mota;
		this.kantitatea = kantitatea;
		this.data = data;
	}
	
	public Produktu_Mugimenduak() {}
	
}
