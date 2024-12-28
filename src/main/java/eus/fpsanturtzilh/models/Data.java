package eus.fpsanturtzilh.models;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.sql.Date;

@Embeddable
@Access(AccessType.PROPERTY)
public class Data {

	private Date sortze_data;
	private Date eguneratze_data;
	private Date ezabatze_data;

	public Data(Date sortze_data, Date eguneratze_data, Date ezabatze_data) {
		this.sortze_data = sortze_data;
		this.eguneratze_data = eguneratze_data;
		this.ezabatze_data = ezabatze_data;
	}

	public Data() {
	}

	public Date getSortze_data() {
		return sortze_data;
	}

	public void setSortze_data(Date sortze_data) {
		this.sortze_data = sortze_data;
	}

	public Date getEguneratze_data() {
		return eguneratze_data;
	}

	public void setEguneratze_data(Date eguneratze_data) {
		this.eguneratze_data = eguneratze_data;
	}

	public Date getEzabatze_data() {
		return ezabatze_data;
	}

	public void setEzabatze_data(Date ezabatze_data) {
		this.ezabatze_data = ezabatze_data;
	}

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