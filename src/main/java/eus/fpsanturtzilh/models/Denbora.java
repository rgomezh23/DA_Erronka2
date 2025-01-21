package eus.fpsanturtzilh.models;

import java.sql.Time;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Access(AccessType.PROPERTY)
public class Denbora {
	private Time hasiera_ordua;
	private Time amaiera_ordua;

	@PrePersist
	public void prePersist() {
		if (hasiera_ordua == null) {
			hasiera_ordua = new Time(System.currentTimeMillis());
		}
		if(amaiera_ordua == null) {
			amaiera_ordua = new Time(System.currentTimeMillis());
		}
	}
}
