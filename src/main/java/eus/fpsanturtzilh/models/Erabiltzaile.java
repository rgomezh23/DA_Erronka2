package eus.fpsanturtzilh.models;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "erabiltzaileak")
public class Erabiltzaile {

	@Id
	private String username;

	private String pasahitza;
	private String rola;

	@Embedded
	private Data data;

	public Erabiltzaile() {
	}

	// Getters y setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasahitza() {
		return pasahitza;
	}

	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}

	public String getRola() {
		return rola;
	}

	public void setRola(String rola) {
		this.rola = rola;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}
}
