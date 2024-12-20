package Models;

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
    
    @OneToMany(mappedBy = "hitzorduak", cascade = CascadeType.ALL) 
    List<Hitzorduak>  hitzorduak;
    
    @OneToMany(mappedBy = "produktu_Mugimenduak", cascade = CascadeType.ALL) 
    List<Produktu_Mugimenduak>  produktu_Mugimenduak;
     
    @OneToMany(mappedBy = "ticket_lerroak", cascade = CascadeType.ALL) 
    List<Ticket_lerroak> ticket_lerroak;
    
    
    @OneToMany(mappedBy = "txandak", cascade = CascadeType.ALL) 
    List<Txandak> txandak;
     
     
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

	public List<Ticket_lerroak> getTicket_lerroak() {
		return ticket_lerroak;
	}

	public void setTicket_lerroak(List<Ticket_lerroak> ticket_lerroak) {
		this.ticket_lerroak = ticket_lerroak;
	}

	public List<Txandak> getTxandak() {
		return txandak;
	}

	public void setTxandak(List<Txandak> txandak) {
		this.txandak = txandak;
	}
	
}
