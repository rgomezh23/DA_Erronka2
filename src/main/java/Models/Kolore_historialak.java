package models;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.sql.Date;


@Entity
@Table(name = "kolore_historialak")
public class Kolore_historialak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @OneToMany
    @JoinColumn(name = "id_bezeroa", nullable = false)
    private BezeroFitxa bezero;
    
    @OneToMany
    @JoinColumn(name = "id_produktua", nullable = false)
    private Produktuak produktu;
    
    
    private String izena;
    private Date data;
    private String abizena;
    private int kantitatea;
    private String bolumena;
    private String oharrak;

    @Embedded
    private Data dataSimple;

	public Kolore_historialak(int id, BezeroFitxa bezero, Produktuak produktu, String izena, Date data, String abizena,
			int kantitatea, String bolumena, String oharrak, Data dataSimple) {
		super();
		this.id = id;
		this.bezero = bezero;
		this.produktu = produktu;
		this.izena = izena;
		this.data = data;
		this.abizena = abizena;
		this.kantitatea = kantitatea;
		this.bolumena = bolumena;
		this.oharrak = oharrak;
		this.dataSimple = dataSimple;
	}


	public Kolore_historialak() {}


	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  
    public BezeroFitxa getBezero() {
		return bezero;
	}

	public void setBezero(BezeroFitxa bezero) {
		this.bezero = bezero;
	}

    public Produktuak getProduktu() {
		return produktu;
	}


	public void setProduktu(Produktuak produktu) {
		this.produktu = produktu;
	}


	public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

	public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getAbizena() {
        return abizena;
    }

    public void setAbizena(String abizena) {
        this.abizena = abizena;
    }

    public int getKantitatea() {
        return kantitatea;
    }

    public void setKantitatea(int kantitatea) {
        this.kantitatea = kantitatea;
    }

    public String getBolumena() {
        return bolumena;
    }

    public void setBolumena(String bolumena) {
        this.bolumena = bolumena;
    }

    public String getOharrak() {
        return oharrak;
    }

    public void setOharrak(String oharrak) {
        this.oharrak = oharrak;
    }

    public Data getDataSimple() {
        return dataSimple;
    }

    public void setDataSimple(Data dataSimple) {
        this.dataSimple = dataSimple;
    }
}
