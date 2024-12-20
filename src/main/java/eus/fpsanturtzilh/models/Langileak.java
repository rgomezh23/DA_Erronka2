package eus.fpsanturtzilh.models;

import java.util.List;

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
    
    @OneToMany(mappedBy = "langileak", cascade = CascadeType.ALL)
    private List<Hitzorduak> hitzorduak;

    
    @OneToMany(mappedBy = "langilea", cascade = CascadeType.ALL)
    private List<Produktu_Mugimenduak> produktu_Mugimenduak;

    
    @OneToMany(mappedBy = "langileak", cascade = CascadeType.ALL)
    private List<Txandak> txandak;

     
     
	public Langileak() {}
	
	public Langileak(int id, String izena, String kodea, String abizenak, Data data, List<Hitzorduak> hitzorduak,
			List<Produktu_Mugimenduak> produktu_Mugimenduak, List<Txandak> txandak) {
		super();
		this.id = id;
		this.izena = izena;
		this.kodea = kodea;
		this.abizenak = abizenak;
		this.data = data;
		this.hitzorduak = hitzorduak;
		this.produktu_Mugimenduak = produktu_Mugimenduak;
		this.txandak = txandak;
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
	
	public void setHitzorduak(List<Hitzorduak> hitzorduak) {
		this.hitzorduak = hitzorduak;
	}

	public List<Hitzorduak> getHitzorduak() {
		return hitzorduak;
	}

	public List<Produktu_Mugimenduak> getProduktu_Mugimenduak() {
		return produktu_Mugimenduak;
	}

	public void setProduktu_Mugimenduak(List<Produktu_Mugimenduak> produktu_Mugimenduak) {
		this.produktu_Mugimenduak = produktu_Mugimenduak;
	}


	public List<Txandak> getTxandak() {
		return txandak;
	}

	public void setTxandak(List<Txandak> txandak) {
		this.txandak = txandak;
	}
	
}
