package Models;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "erabiltzaileak")
public class BezeroFitxa {

	 @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String pasahitza;
    private String izena;
    private String abizena;
    private String telefonoa;
    private boolean azal_sentikorra;
    
    @Embedded
    private Data data;
 

	public BezeroFitxa(int id, String pasahitza, String izena, String abizena, String telefonoa,
			boolean azal_sentikorra, Data data) {
		super();
		this.id = id;
		this.pasahitza = pasahitza;
		this.izena = izena;
		this.abizena = abizena;
		this.telefonoa = telefonoa;
		this.azal_sentikorra = azal_sentikorra;
		this.data = data;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPasahitza() {
		return pasahitza;
	}


	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
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


	public BezeroFitxa() {
		
	}

}
