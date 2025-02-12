package eus.fpsanturtzilh.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


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

	@Column(name = "id_materiala")
	private int materiala_id;


	@Embedded
	private Data data;

	private Date hasieraData;
	private Date amaieraData;

	@Column(name = "id_langilea")
	 private Integer idLangilea;
	 
	 // @Transient // Borrar si rompe.
	 // private Integer idMateriala;
	
	/**
	 	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "id_materiala", nullable = false)
	private Materialak materiala;
	 */

}
