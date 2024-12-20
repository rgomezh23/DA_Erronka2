package models;

import jakarta.persistence.*;

@Entity
@Table(name="ticket_lerroak")
public class Ticket_lerroak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String izena;
    
    @ManyToOne
    @JoinColumn(name = "id_zerbitzua", nullable = false)
    private Zerbitzuak zerbitzuak;
    
    @ManyToOne
    @JoinColumn(name = "id_hitzordua", nullable = false)
    private Hitzorduak hitzorduak;
    
    @Embedded
    Data data;

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
    public Zerbitzuak getZerbitzuak() {
        return zerbitzuak;
    }
    public void setZerbitzuak(Zerbitzuak zerbitzuak) {
        this.zerbitzuak = zerbitzuak;
    }
    
	public Hitzorduak getHitzorduak() {
		return hitzorduak;
	}
	public void setHitzorduak(Hitzorduak hitzorduak) {
		this.hitzorduak = hitzorduak;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public Ticket_lerroak() {}
    
}
