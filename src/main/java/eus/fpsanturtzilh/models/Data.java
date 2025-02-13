package eus.fpsanturtzilh.models;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
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

	@Column(name = "sortze_data")
	private Date sortze_data;

	@Column(name = "eguneratze_data")
	private Date eguneratze_data;

	@Column(name = "ezabatze_data")
	private Date ezabatze_data;

	// Si el código se rompe, borrar los '@Column'.
}