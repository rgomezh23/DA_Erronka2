package Models;

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
    @JoinColumn(name = "id_langilea", nullable = false)
    private Langileak langileak;
    
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
    public Langileak getLangileak() {
        return langileak;
    }
    public void setLangileak(Langileak langileak) {
        this.langileak = langileak;
    }
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	
	public Ticket_lerroak(int id, String izena, Zerbitzuak zerbitzuak, Langileak langileak, Data data) {
		super();
		this.id = id;
		this.izena = izena;
		this.zerbitzuak = zerbitzuak;
		this.langileak = langileak;
		this.data = data;
	}
	
	public Ticket_lerroak() {}
    
}
