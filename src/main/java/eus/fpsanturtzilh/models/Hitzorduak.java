package eus.fpsanturtzilh.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date; // Borrar.
// import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hitzorduak")
public class Hitzorduak {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int eserlekua;

	@Column(name = "id_langilea", nullable = false)
	private Integer id_langilea;

	@Column(name = "data", nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date data;

	@Column(name = "hasiera_ordua", nullable = false)
	@JsonFormat(pattern = "HH:mm:ss")
	private Time hasiera_ordua;

	@Column(name = "amaiera_ordua", nullable = false)
	@JsonFormat(pattern = "HH:mm:ss")
	private Time amaiera_ordua;

	@Column(name = "hasiera_ordua_erreala")
	@JsonFormat(pattern = "HH:mm:ss")
	private Time hasiera_ordua_erreala;

	@Column(name = "amaiera_ordua_erreala")
	@JsonFormat(pattern = "HH:mm:ss")
	private Time amaiera_ordua_erreala;

	@Column(nullable = false, length = 100)
	private String izena;

	@Column(length = 9)
	private String telefonoa;

	@Column(length = 250)
	private String deskribapena;

	@Column(nullable = false)
	private char etxekoa;

	@Column(precision = 10, scale = 2)
	private BigDecimal prezio_totala;

	@Embedded
	private Data dataSimple;

}
