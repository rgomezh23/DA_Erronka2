package Models;

import jakarta.persistence.*;

@Entity
public class BezeroFitxak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String izena;
    private String abizenak;
    private String emaila;
    
    @Embedded
    private Data dataSimple;

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

	public String getAbizenak() {
		return abizenak;
	}

	public void setAbizenak(String abizenak) {
		this.abizenak = abizenak;
	}

	public String getEmaila() {
		return emaila;
	}

	public void setEmaila(String emaila) {
		this.emaila = emaila;
	}

	public Data getDataSimple() {
		return dataSimple;
	}

	public void setDataSimple(Data dataSimple) {
		this.dataSimple = dataSimple;
	}

	public BezeroFitxak(int id, String izena, String abizenak, String emaila, Data dataSimple) {
		super();
		this.id = id;
		this.izena = izena;
		this.abizenak = abizenak;
		this.emaila = emaila;
		this.dataSimple = dataSimple;
	}
	
	public BezeroFitxak() {}
}
