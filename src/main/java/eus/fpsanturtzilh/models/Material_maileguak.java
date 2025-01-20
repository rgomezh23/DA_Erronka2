package eus.fpsanturtzilh.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "material_maileguak")
public class Material_maileguak {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "id_materiala", nullable = false)
	private Materialak materiala;

	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "id_langilea", nullable = false)
	private Langileak langilea;

	@Embedded
	private Data data;

	private Date hasieraData;
	private Date amaieraData;
	
	 @JsonProperty("id_materiala")  //materiala agertzeko
	    public long getMaterialaID() {
	        return materiala != null ? materiala.getId() : 0;  
	    }
	 

	 @JsonProperty("materiala_izena")  //materiala agertzeko
	    public String getMaterialaIzena() {
	        return materiala != null ? materiala.getIzena() : null;  
	    }
	 
	 @JsonProperty("materiala_etiketa")  //materiala agertzeko
	    public String getMaterialaEtiketa() {
	        return materiala != null ? materiala.getEtiketa() : null;  
	    }
}
