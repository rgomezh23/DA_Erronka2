package eus.fpsanturtzilh.models;

import java.sql.Date;

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
@Table(name = "ordutegiak")
public class Ordutegiak {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String kodea;
	private int eguna;
	private Date hasiera_data;
	private Date amaiera_data;

	@Embedded
	private Data data;

	@Embedded
	private Denbora denbora;

}
