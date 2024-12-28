package eus.fpsanturtzilh.models;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "kolore_historialak")
public class Kolore_historialak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "id_bezeroa", nullable = false)
    @JsonBackReference
    private Bezero_fitxak bezero;

    
    @ManyToOne
    @JoinColumn(name = "id_produktua", nullable = false)
    @JsonBackReference
    private Produktuak produktu;
    
    
    private Date data;
    private int kantitatea;
    private String bolumena;
    private String oharrak;

    @Embedded
    private Data dataSimple;

	public Kolore_historialak(int id, Bezero_fitxak bezero, Produktuak produktu, Date data,
			int kantitatea, String bolumena, String oharrak, Data dataSimple) {
		super();
		this.id = id;
		this.bezero = bezero;
		this.produktu = produktu;
		this.data = data;
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

  
    public Bezero_fitxak getBezero() {
		return bezero;
	}

	public void setBezero(Bezero_fitxak bezero) {
		this.bezero = bezero;
	}

    public Produktuak getProduktu() {
		return produktu;
	}


	public void setProduktu(Produktuak produktu) {
		this.produktu = produktu;
	}

	public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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
