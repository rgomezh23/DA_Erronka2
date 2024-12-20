package Models;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "hitzorduak")
public class Hitzorduak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String pasahitza;
    private String izena;
    private String abizena;
    private int eserlekua;
    private String telefonoa;
    private String deskribapena;
    private Date data;
    private char etxekoa;
    private double prezio_totala;
    
    @ManyToOne
    @JoinColumn(name = "langile_id")
    private Langileak langileak;
    
    @OneToMany(mappedBy = "ticket_lerroak", cascade = CascadeType.ALL)
    private List<Ticket_lerroak> ticket_lerroak;
    
    private boolean azal_sentikorra;

    @Embedded
    private DenboraErreala denbora;

    @Embedded
    private Data dataSimple;

	
	
	public Hitzorduak() {}

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


	public int getEserlekua() {
		return eserlekua;
	}


	public void setEserlekua(int eserlekua) {
		this.eserlekua = eserlekua;
	}


	public String getTelefonoa() {
		return telefonoa;
	}


	public void setTelefonoa(String telefonoa) {
		this.telefonoa = telefonoa;
	}


	public String getDeskribapena() {
		return deskribapena;
	}


	public void setDeskribapena(String deskribapena) {
		this.deskribapena = deskribapena;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public char getEtxekoa() {
		return etxekoa;
	}


	public void setEtxekoa(char etxekoa) {
		this.etxekoa = etxekoa;
	}


	public double getPrezio_totala() {
		return prezio_totala;
	}


	public void setPrezio_totala(double prezio_totala) {
		this.prezio_totala = prezio_totala;
	}


	public Langileak getLangileak() {
		return langileak;
	}

	public void setLangileak(Langileak langileak) {
		this.langileak = langileak;
	}

	public boolean isAzal_sentikorra() {
		return azal_sentikorra;
	}


	public void setAzal_sentikorra(boolean azal_sentikorra) {
		this.azal_sentikorra = azal_sentikorra;
	}


	public DenboraErreala getDenbora() {
		return denbora;
	}


	public void setDenbora(DenboraErreala denbora) {
		this.denbora = denbora;
	}


	public Data getDataSimple() {
		return dataSimple;
	}


	public void setDataSimple(Data dataSimple) {
		this.dataSimple = dataSimple;
	}
}
