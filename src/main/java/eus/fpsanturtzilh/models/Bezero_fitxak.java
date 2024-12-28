package eus.fpsanturtzilh.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "bezero_fitxak")
public class Bezero_fitxak {

	 @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String izena;
    private String abizena;
    private String telefonoa;
    private boolean azal_sentikorra;
    
    @OneToMany(mappedBy = "bezero", cascade = CascadeType.ALL)
    private List<Kolore_historialak>  historiala;
   
    @Embedded
    private Data data;
 

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


	public String getAbizena() {
		return abizena;
	}


	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}


	public String getTelefonoa() {
		return telefonoa;
	}


	public void setTelefonoa(String telefonoa) {
		this.telefonoa = telefonoa;
	}


	public boolean isAzal_sentikorra() {
		return azal_sentikorra;
	}


	public void setAzal_sentikorra(boolean azal_sentikorra) {
		this.azal_sentikorra = azal_sentikorra;
	}


	public Data getData() {
		return data;
	}


	public void setData(Data data) {
		this.data = data;
	}

	public Bezero_fitxak() {}

}
