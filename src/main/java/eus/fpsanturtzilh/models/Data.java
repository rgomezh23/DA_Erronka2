package eus.fpsanturtzilh.models;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Access(AccessType.PROPERTY)
public class Data {

	private Date sortze_data;
	private Date eguneratze_data;
	private Date ezabatze_data;


	// En caso de error liberar esto:

	/**
	 * @PrePersist public void prePersist() { if (sortze_data == null) { sortze_data
	 *             = new Date(System.currentTimeMillis()); } if (eguneratze_data ==
	 *             null) { eguneratze_data = new Date(System.currentTimeMillis()); }
	 *             if (ezabatze_data == null) { ezabatze_data = new
	 *             Date(System.currentTimeMillis()); } }
	 * 
	 * @PreUpdate public void preUpdate() { eguneratze_data = new
	 *            Date(System.currentTimeMillis()); }
	 */
}