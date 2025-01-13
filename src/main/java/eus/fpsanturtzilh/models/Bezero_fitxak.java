package eus.fpsanturtzilh.models;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "bezero_fitxak")
public class Bezero_fitxak {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String izena;
	private String abizena;
	private String telefonoa;
	private String azal_sentikorra;

	@Embedded
	private Data data;

	@OneToMany(mappedBy = "bezero", cascade = CascadeType.ALL)
	private List<Kolore_historialak> historiala;

	public long getId() {
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

	public String getAbizena() {
		return abizena;
	}

	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}

	public String getTelefonoa() {
		return telefonoa;
	}

	public void setTelefonoa(String telefonoa) {
		this.telefonoa = telefonoa;
	}

	public String getAzal_sentikorra() {
		return azal_sentikorra;
	}

	public void setAzal_sentikorra(String azal_sentikorra) {
		this.azal_sentikorra = azal_sentikorra;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public List<Kolore_historialak> getHistoriala() {
		return historiala;
	}

	public void setHistoriala(List<Kolore_historialak> historiala) {
		this.historiala = historiala;
	}

	@PrePersist
	@PreUpdate
	public void mapAzalSentikorra() {
		if (!"B".equals(azal_sentikorra) && !"E".equals(azal_sentikorra)) {
			throw new IllegalArgumentException("Azal_sentikorra must be 'B' or 'E'");
		}
	}

	public Bezero_fitxak() {
	}
}

// ELIMINADO: Pasahitza.
// Modificado para que ponga 'B' o 'E'.