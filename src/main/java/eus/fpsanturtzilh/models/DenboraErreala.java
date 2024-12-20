package eus.fpsanturtzilh.models;

import java.sql.Time;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;

@Embeddable
@Access(AccessType.PROPERTY)  
public class DenboraErreala {
	  private Time hasiera_ordua_erreala;
	  private Time amaiera_ordua_erreala;
	  
	  @PrePersist
	    public void prePersist() {
		  if (hasiera_ordua_erreala == null) {
	            hasiera_ordua_erreala = new Time(System.currentTimeMillis());  // Hora actual
	        }
	  }

	public DenboraErreala(Time hasiera_ordua_erreala, Time amaiera_ordua_erreala) {
		super();
		
		this.hasiera_ordua_erreala = hasiera_ordua_erreala;
		this.amaiera_ordua_erreala = amaiera_ordua_erreala;
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
}
