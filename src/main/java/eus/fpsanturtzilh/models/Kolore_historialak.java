package eus.fpsanturtzilh.models;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "kolore_historialak")
public class Kolore_historialak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "id_bezeroa", nullable = false)
    private Bezero_fitxak bezero;

    @ManyToOne
    @JoinColumn(name = "id_produktua", nullable = false)
    private Produktuak produktu;
    
    private Date data;
    private int kantitatea;
    private String bolumena;
    private String oharrak;

    @Embedded
    private Data dataSimple;

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
