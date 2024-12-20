package models;

import jakarta.persistence.*;

@Entity
@Table(name = "taldeak")
public class Taldeak {
    @Id
    private String kodea;
    
    private String izena;
    
    @Embedded
    Data data;

    public String getKodea() {
        return kodea;
    }
    public void setKodea(String kodea) {
        this.kodea = kodea;
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
	
	public Taldeak(String kodea, String izena, Data data) {
		super();
		this.kodea = kodea;
		this.izena = izena;
		this.data = data;
	}
	
	public Taldeak() {}
	
	
   
}
