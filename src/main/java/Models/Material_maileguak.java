package Models;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "material_maileguak")
public class Material_maileguak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private int id_materiala;
    private int id_langilea;
  
    @Embedded
    private Data data;
    
    @Embedded
    private DenboraErreala denbora;

    public Material_maileguak(int id, int id_materiala, int id_langilea, Data data, DenboraErreala denbora) {
		super();
		this.id = id;
		this.id_materiala = id_materiala;
		this.id_langilea = id_langilea;
		this.data = data;
		this.denbora = denbora;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getId_materiala() {
		return id_materiala;
	}


	public void setId_materiala(int id_materiala) {
		this.id_materiala = id_materiala;
	}


	public int getId_langilea() {
		return id_langilea;
	}


	public void setId_langilea(int id_langilea) {
		this.id_langilea = id_langilea;
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


	

    
	public Material_maileguak() {}
}
