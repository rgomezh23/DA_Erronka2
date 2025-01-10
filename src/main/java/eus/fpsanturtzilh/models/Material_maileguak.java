package eus.fpsanturtzilh.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "material_maileguak")
public class Material_maileguak {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "id_materiala", nullable = false)
	private Materialak materiala;

	@ManyToOne
	@JoinColumn(name = "id_langilea", nullable = false)
	private Langileak langilea;

	@Embedded
	private Data data;

	private Date hasieraData;
	private Date amaieraData;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Materialak getMateriala() {
		return materiala;
	}

	public void setMateriala(Materialak materiala) {
		this.materiala = materiala;
	}

	public Langileak getLangilea() {
		return langilea;
	}

	public void setLangilea(Langileak langilea) {
		this.langilea = langilea;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public Date getHasieraData() {
		return hasieraData;
	}

	public void setHasieraData(Date hasieraData) {
		this.hasieraData = hasieraData;
	}

	public Date getAmaieraData() {
		return amaieraData;
	}

	public void setAmaieraData(Date amaieraData) {
		this.amaieraData = amaieraData;
	}

	public Material_maileguak() {
	}
}
