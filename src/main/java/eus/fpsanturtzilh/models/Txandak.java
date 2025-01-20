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
@Table(name = "txandak")

public class Txandak {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private char mota;
	private Date data;

	@ManyToOne
	@JoinColumn(name = "id_langilea", nullable = false)
	private Langileak langileak;

	@Embedded
	Data dataSimple;

}
