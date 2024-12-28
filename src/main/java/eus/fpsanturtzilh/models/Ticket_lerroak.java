package eus.fpsanturtzilh.models;

import jakarta.persistence.*;
import java.math.BigDecimal; // Importante para BigDecimal

@Entity
@Table(name = "ticket_lerroak")
public class Ticket_lerroak {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "id_zerbitzua", nullable = false)
	private Zerbitzuak zerbitzuak;

	@ManyToOne
	@JoinColumn(name = "id_hitzordua", nullable = false)
	private Hitzorduak hitzorduak;

	@Embedded
	private Data data;

	@Column(name = "prezioa", nullable = false)
	private BigDecimal prezioa;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public BigDecimal getPrezioa() {
		return prezioa;
	}

	public void setPrezioa(BigDecimal prezioa) {
		this.prezioa = prezioa;
	}

	public Ticket_lerroak() {
	}
}

// Eliminado: Izena
// Agregado: Prezioa.
