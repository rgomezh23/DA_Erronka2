package eus.fpsanturtzilh.models;


import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "materialak")
public class Materialak {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String etiketa;
	private String izena;
	
	@Embedded
	Data data;

}
