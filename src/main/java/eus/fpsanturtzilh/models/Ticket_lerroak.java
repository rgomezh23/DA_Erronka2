package eus.fpsanturtzilh.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal; // Importante para BigDecimal

@Entity
@Table(name = "ticket_lerroak")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

}

