package eus.fpsanturtzilh.models;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Access(AccessType.PROPERTY)
public class DenboraErreala {
	  private Time hasiera_ordua_erreala;
	  private Time amaiera_ordua_erreala;
	  

	@PrePersist
	public void prePersist() {
		if (hasiera_ordua_erreala == null) {
			hasiera_ordua_erreala = new Time(System.currentTimeMillis());
		}
	}
}
