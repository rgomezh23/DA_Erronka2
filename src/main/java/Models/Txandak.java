package Models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "txandak")
public class Txandak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private char mota;
    private Date data;
    
    @ManyToOne
    @JoinColumn(name = "id_langilea", nullable = false)
    private Langileak langileak;
    
    @Embedded
    Data dataSimple;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public char getMota() {
        return mota;
    }
    public void setMota(char mota) {
        this.mota = mota;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public Langileak getLangileak() {
        return langileak;
    }
    public void setLangileak(Langileak langileak) {
        this.langileak = langileak;
    }
	public Data getDataSimple() {
		return dataSimple;
	}
	public void setDataSimple(Data dataSimple) {
		this.dataSimple = dataSimple;
	}
	
	public Txandak(int id, char mota, Date data, Langileak langileak, Data dataSimple) {
		super();
		this.id = id;
		this.mota = mota;
		this.data = data;
		this.langileak = langileak;
		this.dataSimple = dataSimple;
	}
	
	public Txandak() {}
    
    
}
