package Models;

import jakarta.persistence.*;

@Entity
@Table(name="zerbitzuak")
public class Zerbitzuak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String izena;
    private double etxeko_prezioa;
    private double kanpoko_prezioa;
    
    @Embedded
    Data data;
    
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
 
	public double getEtxeko_prezioa() {
		return etxeko_prezioa;
	}
	public void setEtxeko_prezioa(double etxeko_prezioa) {
		this.etxeko_prezioa = etxeko_prezioa;
	}
	public double getKanpoko_prezioa() {
		return kanpoko_prezioa;
	}
	public void setKanpoko_prezioa(double kanpoko_prezioa) {
		this.kanpoko_prezioa = kanpoko_prezioa;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	
	public Zerbitzuak(int id, String izena,double etxeko_prezioa, double kanpoko_prezioa,Data data) {
		super();
		this.id = id;
		this.izena = izena;
		this.etxeko_prezioa = etxeko_prezioa;
		this.kanpoko_prezioa = kanpoko_prezioa;
		this.data = data;
	}
	
	public Zerbitzuak() {}
    
}
