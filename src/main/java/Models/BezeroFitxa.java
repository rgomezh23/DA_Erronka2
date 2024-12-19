package Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "BezeroFitxak")
public class BezeroFitxa {

	 @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String pasahitza;
    private String izena;
    private String abizena;
    private String telefonoa;
    private boolean azal_sentikorra;
    
    @OneToMany(mappedBy = "kolore_historialak", cascade = CascadeType.ALL)
    private Kolore_historialak historiala;
   
    @Embedded
    private Data data;
 

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

	

	public Kolore_historialak getHistoriala() {
		return historiala;
	}


	public void setHistoriala(Kolore_historialak historiala) {
		this.historiala = historiala;
	}


	public BezeroFitxa(int id, String pasahitza, String izena, String abizena, String telefonoa,
			boolean azal_sentikorra, Kolore_historialak historiala, Data data) {
		super();
		this.id = id;
		this.pasahitza = pasahitza;
		this.izena = izena;
		this.abizena = abizena;
		this.telefonoa = telefonoa;
		this.azal_sentikorra = azal_sentikorra;
		this.historiala = historiala;
		this.data = data;
	}

	public BezeroFitxa() {}

}
