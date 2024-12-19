package Models;

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

    // Constructor vacío
    public Data() {}

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

    // @PrePersist: se ejecuta antes de insertar el objeto
    @PrePersist
    public void prePersist() {
        // Establecer la fecha de creación
        if (sortze_data == null) {
            sortze_data = new Date(System.currentTimeMillis());  // Fecha actual
        }
        if (eguneratze_data == null) {
            eguneratze_data = new Date(System.currentTimeMillis());  // Fecha actual
        }
        if (ezabatze_data == null) {
            ezabatze_data = new Date(System.currentTimeMillis());  // Fecha actual
        }
    }

    // @PreUpdate: se ejecuta antes de actualizar el objeto
    @PreUpdate
    public void preUpdate() {
        // Actualizar la fecha de modificación
        eguneratze_data = new Date(System.currentTimeMillis());  // Fecha actual
    }
}
