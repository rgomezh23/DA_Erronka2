package Models;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "kategoriak")
public class Kategoriak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String izena;
    private String abizena;


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


	public Data getData() {
		return data;
	}


	public void setData(Data data) {
		this.data = data;
	}


	public Kategoriak(int id, String izena, String abizena, Data data) {
		super();
		this.id = id;
		this.izena = izena;
		this.abizena = abizena;
		this.data = data;
	}

}
