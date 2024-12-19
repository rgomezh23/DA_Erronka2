package Models;

import jakarta.persistence.*;

@Entity
@Table(name="langileak")
public class Langileak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String izena;
    private String kodea;
    private String abizenak;
    
    @Embedded
    Data data;
    
    @OneToMany(mappedBy = "hitzorduak", cascade = CascadeType.ALL) 
    Hitzorduak hitzorduak;
    
    
    public Langileak(int id, String izena, String kodea, String abizenak, Data data, Hitzorduak hitzorduak) {
		super();
		this.id = id;
		this.izena = izena;
		this.kodea = kodea;
		this.abizenak = abizenak;
		this.data = data;
		this.hitzorduak = hitzorduak;
	}
    
    public Langileak() {}
    
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
    public String getKodea() {
        return kodea;
    }
    public void setKodea(String kodea) {
        this.kodea = kodea;
    }
    public String getAbizenak() {
        return abizenak;
    }
    public void setAbizenak(String abizenak) {
        this.abizenak = abizenak;
    }
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	
	public Hitzorduak getHitzorduak() {
		return hitzorduak;
	}
	public void setHitzorduak(Hitzorduak hitzorduak) {
		this.hitzorduak = hitzorduak;
	}
	
}
