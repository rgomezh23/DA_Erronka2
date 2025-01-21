package eus.fpsanturtzilh.models;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "erabiltzaileak")
public class Erabiltzaile {

	@Id
	private String username;
	private String pasahitza;
	private String rola;

	@Embedded
	private Data data;

}
