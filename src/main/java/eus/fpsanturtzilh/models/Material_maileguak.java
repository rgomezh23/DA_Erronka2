package eus.fpsanturtzilh.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "material_maileguak")
public class Material_maileguak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="id_materiala")
    private Materialak materiala;
    
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="id_langilea")
    private Langileak langilea;
  
    @Embedded
    private Data data;
    
    @Embedded
    private DenboraErreala denbora;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Data getData() {
		return data;
	}


	public void setData(Data data) {
		this.data = data;
	}


	public DenboraErreala getDenbora() {
		return denbora;
	}


	public void setDenbora(DenboraErreala denbora) {
		this.denbora = denbora;
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


	public Material_maileguak() {}
}
