package Models;


import java.sql.Time;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;

@Embeddable
@Access(AccessType.PROPERTY)  
public class Denbora {
	  private Time hasiera_ordua;
	  private Time amaiera_ordua;
	  
	  @PrePersist
	    public void prePersist() {
		  if (hasiera_ordua == null) {
	            hasiera_ordua = new Time(System.currentTimeMillis());  // Hora actual
	        }
	  }

	public Time getHasiera_ordua() {
		return hasiera_ordua;
	}

	public void setHasiera_ordua(Time hasiera_ordua) {
		this.hasiera_ordua = hasiera_ordua;
	}

	public Time getAmaiera_ordua() {
		return amaiera_ordua;
	}

	public void setAmaiera_ordua(Time amaiera_ordua) {
		this.amaiera_ordua = amaiera_ordua;
	}

	public Denbora(Time hasiera_ordua, Time amaiera_ordua) {
		super();
		this.hasiera_ordua = hasiera_ordua;
		this.amaiera_ordua = amaiera_ordua;
	}
}
