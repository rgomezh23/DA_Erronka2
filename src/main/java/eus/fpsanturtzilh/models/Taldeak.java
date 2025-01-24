package eus.fpsanturtzilh.models;

import java.util.List;

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
@Table(name = "taldeak")
public class Taldeak {
	@Id
	private String kodea;
	private String izena;

	@Embedded
	Data data;
	
	@OneToMany
	@JoinColumn(name = "kodea", nullable = false, insertable = false, updatable = false)
	private List<Langileak> langileak;

}
