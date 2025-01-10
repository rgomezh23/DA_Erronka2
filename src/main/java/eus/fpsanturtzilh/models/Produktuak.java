package eus.fpsanturtzilh.models;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Produktuak {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String izena;
	private String deskribapena;
	private String marka;
	private int stock;
	private int stock_alerta;

	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "id_kategoria", nullable = false)
	private Kategoriak kategoriak;

	@OneToMany(mappedBy = "produktu", cascade = CascadeType.ALL)
	private List<Kolore_historialak> Kolore_historialak;

	@OneToMany(mappedBy = "produktuak", cascade = CascadeType.ALL)
	private List<Produktu_Mugimenduak> produktu_Mugimenduak;

	@Embedded
	private Data data;

    public Produktuak(Long id, String izena, String deskribapena, String marka, int stock, int stock_alerta,
                      Kategoriak kategoriak, List<Kolore_historialak> kolore_historialak,
                      List<Produktu_Mugimenduak> produktu_Mugimenduak, Data data) {
        this.id = id;
        this.izena = izena;
        this.deskribapena = deskribapena;
        this.marka = marka;
        this.stock = stock;
        this.stock_alerta = stock_alerta;
        this.kategoriak = kategoriak;
        this.Kolore_historialak = kolore_historialak;
        this.produktu_Mugimenduak = produktu_Mugimenduak;
        this.data = data;
    }
    
    @JsonProperty("id_kategoria")  //kategoria agertzeko
    public int getKategoriaId() {
        return kategoriak != null ? kategoriak.getId() : 0;  
    }
    
    public Produktuak() {
    }

    public Long getId() {
        return id;
    }

	public void setId(int id) {
		this.id = (long) id;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getDeskribapena() {
		return deskribapena;
	}

	public void setDeskribapena(String deskribapena) {
		this.deskribapena = deskribapena;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getStock_alerta() {
		return stock_alerta;
	}

	public void setStock_alerta(int stock_alerta) {
		this.stock_alerta = stock_alerta;
	}

	public Kategoriak getKategoriak() {
		return kategoriak;
	}

	public void setKategoriak(Kategoriak kategoriak) {
		this.kategoriak = kategoriak;
	}

	public List<Kolore_historialak> getKolore_historialak() {
		return Kolore_historialak;
	}

	public void setKolore_historialak(List<Kolore_historialak> kolore_historialak) {
		Kolore_historialak = kolore_historialak;
	}

	public List<Produktu_Mugimenduak> getProduktu_Mugimenduak() {
		return produktu_Mugimenduak;
	}

	public void setProduktu_Mugimenduak(List<Produktu_Mugimenduak> produktu_Mugimenduak) {
		this.produktu_Mugimenduak = produktu_Mugimenduak;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}
}

// Eliminado: Prezioa.