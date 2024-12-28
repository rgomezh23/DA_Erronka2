package eus.fpsanturtzilh.models;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "zerbitzuak")
public class Zerbitzuak {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String izena;
	private double etxeko_prezioa;
	private double kanpoko_prezioa;

	@Embedded
	Data data;

	@OneToMany(mappedBy = "zerbitzuak", cascade = CascadeType.ALL)
	List<Ticket_lerroak> ticket_lerroak;

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

	public double getEtxeko_prezioa() {
		return etxeko_prezioa;
	}

	public void setEtxeko_prezioa(double etxeko_prezioa) {
		this.etxeko_prezioa = etxeko_prezioa;
	}

	public double getKanpoko_prezioa() {
		return kanpoko_prezioa;
	}

	public void setKanpoko_prezioa(double kanpoko_prezioa) {
		this.kanpoko_prezioa = kanpoko_prezioa;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public Zerbitzuak() {
	}

}
