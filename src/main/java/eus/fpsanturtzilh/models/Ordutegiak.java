package eus.fpsanturtzilh.models;

import java.sql.Date;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordutegiak")
public class Ordutegiak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String kodea;
    private int eguna;
    private Date hasiera_data;
    private Date amaiera_data;
    

    @Embedded
    private Data data;
    
    @Embedded
    private Denbora denbora;
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKodea() {
		return kodea;
	}

	public void setKodea(String kodea) {
		this.kodea = kodea;
	}

	public int getEguna() {
		return eguna;
	}

	public void setEguna(int eguna) {
		this.eguna = eguna;
	}

	public Date getHasiera_data() {
		return hasiera_data;
	}

	public void setHasiera_data(Date hasiera_data) {
		this.hasiera_data = hasiera_data;
	}

	public Date getAmaiera_data() {
		return amaiera_data;
	}

	public void setAmaiera_data(Date amaiera_data) {
		this.amaiera_data = amaiera_data;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public Denbora getDenbora() {
		return denbora;
	}

	public void setDenbora(Denbora denbora) {
		this.denbora = denbora;
	}

	
	public Ordutegiak(int id, String kodea, int eguna, Date hasiera_data, Date amaiera_data, Data data,
			Denbora denbora) {
		super();
		this.id = id;
		this.kodea = kodea;
		this.eguna = eguna;
		this.hasiera_data = hasiera_data;
		this.amaiera_data = amaiera_data;
		this.data = data;
		this.denbora = denbora;
	}

	public Ordutegiak() {}
}
