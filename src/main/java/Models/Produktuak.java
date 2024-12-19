package Models;

import jakarta.persistence.*;

@Entity
public class Produktuak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String izena;
    private double prezioa;
    private String deskribapena;
    private String marka;
    private int stock;
    private int stock_alerta;
    
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

	@ManyToOne
    @JoinColumn(name = "id_kategoria", nullable = false)
    private Kategoriak kategoriak;
    
   @Embedded
   Data data;
    // Getters and setters
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
    public double getPrezioa() {
        return prezioa;
    }
    public void setPrezioa(double prezioa) {
        this.prezioa = prezioa;
    }
    public Kategoriak getKategoriak() {
        return kategoriak;
    }
    public void setKategoriak(Kategoriak kategoriak) {
        this.kategoriak = kategoriak;
    }
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	
	public Produktuak(int id, String izena, double prezioa, String deskribapena, String marka, int stock,
			int stock_alerta, Kategoriak kategoriak, Data data) {
		super();
		this.id = id;
		this.izena = izena;
		this.prezioa = prezioa;
		this.deskribapena = deskribapena;
		this.marka = marka;
		this.stock = stock;
		this.stock_alerta = stock_alerta;
		this.kategoriak = kategoriak;
		this.data = data;
	}
	public Produktuak() {
		
	}
}

