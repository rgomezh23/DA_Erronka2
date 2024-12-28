package eus.fpsanturtzilh.models;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;

import java.sql.Time;

@Embeddable
@Access(AccessType.PROPERTY)
public class DenboraErreala {

	private Time hasiera_ordua_erreala;
	private Time amaiera_ordua_erreala;

	public DenboraErreala() {
	}

	public DenboraErreala(Time hasiera_ordua_erreala) {
		this.hasiera_ordua_erreala = hasiera_ordua_erreala;
	}

	public Time getHasiera_ordua_erreala() {
		return hasiera_ordua_erreala;
	}

	public void setHasiera_ordua_erreala(Time hasiera_ordua_erreala) {
		this.hasiera_ordua_erreala = hasiera_ordua_erreala;
	}

	public Time getAmaiera_ordua_erreala() {
		return amaiera_ordua_erreala;
	}

	public void setAmaiera_ordua_erreala(Time amaiera_ordua_erreala) {
		this.amaiera_ordua_erreala = amaiera_ordua_erreala;
	}

	@PrePersist
	public void prePersist() {
		if (hasiera_ordua_erreala == null) {
			hasiera_ordua_erreala = new Time(System.currentTimeMillis());
		}
	}
}

// Eliminado: amaiera_ordua_erreala / hasiera_ordua_erreala.
// Bueno, lo he puesto en '@Transient' para que no se persista ni se inserte ni haga gilipolleces.
// Tengo que revisar esta clase en el futuro.