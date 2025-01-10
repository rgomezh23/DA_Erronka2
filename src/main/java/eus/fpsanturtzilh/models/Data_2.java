package eus.fpsanturtzilh.models;

import java.time.LocalDateTime;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Embeddable
@Access(AccessType.PROPERTY)
public class Data_2 { // Esta clase está hecha por GPT, y según me he asegurado, no pasa nada si se elimina.
					  // Pero por ahora se va a quedar ocupando espacio.

    private LocalDateTime sortze_data;
    private LocalDateTime eguneratze_data;
    private LocalDateTime ezabatze_data;

    public Data_2(LocalDateTime sortze_data, LocalDateTime eguneratze_data, LocalDateTime ezabatze_data) {
        this.sortze_data = sortze_data;
        this.eguneratze_data = eguneratze_data;
        this.ezabatze_data = ezabatze_data;
    }

    // Constructor vacío
    public Data_2() {}

    public LocalDateTime getSortze_data() {
        return sortze_data;
    }

    public void setSortze_data(LocalDateTime sortze_data) {
        this.sortze_data = sortze_data;
    }

    public LocalDateTime getEguneratze_data() {
        return eguneratze_data;
    }

    public void setEguneratze_data(LocalDateTime eguneratze_data) {
        this.eguneratze_data = eguneratze_data;
    }

    public LocalDateTime getEzabatze_data() {
        return ezabatze_data;
    }

    public void setEzabatze_data(LocalDateTime ezabatze_data) {
        this.ezabatze_data = ezabatze_data;
    }

    // @PrePersist: se ejecuta antes de insertar el objeto
    @PrePersist
    public void prePersist() {
        // Establecer la fecha de creación
        if (sortze_data == null) {
            sortze_data = LocalDateTime.now();  // Fecha actual
        }
        if (eguneratze_data == null) {
            eguneratze_data = LocalDateTime.now();  // Fecha actual
        }
        if (ezabatze_data == null) {
            ezabatze_data = LocalDateTime.now();  // Fecha actual
        }
    }

    // @PreUpdate: se ejecuta antes de actualizar el objeto
    @PreUpdate
    public void preUpdate() {
        // Actualizar la fecha de modificación
        eguneratze_data = LocalDateTime.now();  // Fecha actual
    }
}

