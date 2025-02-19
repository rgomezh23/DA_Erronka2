package eus.fpsanturtzilh.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "langileak")
public class Langileak {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String izena;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name = "kodea", referencedColumnName = "kodea", nullable = false)
	private Taldeak taldeak;

	@Column(name = "kodea", nullable = false, insertable = false, updatable = false)
	@JsonProperty("kodea")
	private String kode;

	private String abizenak;

	@Embedded
	private Data data;
}
