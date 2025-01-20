package eus.fpsanturtzilh.models;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "hitzorduak")
public class Hitzorduak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int eserlekua;

    @Column(name = "data", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date data;

    @Column(name = "hasiera_ordua", nullable = false)
    @JsonFormat(pattern = "HH:mm:ss")
    private Time hasiera_ordua;

    @Column(name = "amaiera_ordua", nullable = false)
    @JsonFormat(pattern = "HH:mm:ss")
    private Time amaiera_ordua;

    @Column(name = "hasiera_ordua_erreala")
    @JsonFormat(pattern = "HH:mm:ss")
    private Time hasiera_ordua_erreala;

    @Column(name = "amaiera_ordua_erreala")
    @JsonFormat(pattern = "HH:mm:ss")
    private Time amaiera_ordua_erreala;

    @Column(nullable = false, length = 100)
    private String izena;

    @Column(length = 9)
    private String telefonoa;

    @Column(length = 250)
    private String deskribapena;

    @Column(nullable = false)
    private char etxekoa;

    @Column(precision = 10, scale = 2)
    private BigDecimal prezio_totala;

    @ManyToOne
    @JoinColumn(name = "id_langilea")
    @JsonIgnore  // Ignorar la serialización de la propiedad langileak
    private Langileak langileak;

    @Embedded
    private Data dataSimple;

    // Resto de la clase...



	public Hitzorduak() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEserlekua() {
		return eserlekua;
	}

	public void setEserlekua(int eserlekua) {
		this.eserlekua = eserlekua;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		if (izena != null && izena.length() <= 100) {
			this.izena = izena;
		} else {
			throw new IllegalArgumentException("Izena must be non-null and up to 100 characters.");
		}
	}

	public String getTelefonoa() {
		return telefonoa;
	}

	public void setTelefonoa(String telefonoa) {
		if (telefonoa == null || telefonoa.length() == 9) {
			this.telefonoa = telefonoa;
		} else {
			throw new IllegalArgumentException("Telefonoa must be exactly 9 characters or null.");
		}
	}

	public String getDeskribapena() {
		return deskribapena;
	}

	public void setDeskribapena(String deskribapena) {
		if (deskribapena == null || deskribapena.length() <= 250) {
			this.deskribapena = deskribapena;
		} else {
			throw new IllegalArgumentException("Deskribapena must be null or up to 250 characters.");
		}
	}

	public char getEtxekoa() {
		return etxekoa;
	}

	public void setEtxekoa(char etxekoa) {
		if (etxekoa == 'E' || etxekoa == 'K') {
			this.etxekoa = etxekoa;
		} else {
			throw new IllegalArgumentException("Etxekoa must be 'E' or 'K'.");
		}
	}

	public BigDecimal getPrezio_totala() {
		return prezio_totala;
	}

	public void setPrezio_totala(BigDecimal prezio_totala) {
		this.prezio_totala = prezio_totala;
	}

	public Langileak getLangileak() {
		return langileak;
	}

	public void setLangileak(Langileak langileak) {
		this.langileak = langileak;
	}

	public Data getDataSimple() {
		return dataSimple;
	}

	public void setDataSimple(Data dataSimple) {
		this.dataSimple = dataSimple;
	}
}

// Eliminado: abizena / azal sentikorra / pasahitza
// Más cambios, hechos por chat GPT porque no entendía nada.

/**
Antigua clase:
package eus.fpsanturtzilh.models;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "hitzorduak")
public class Hitzorduak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int eserlekua;

    @Column(nullable = false)
    private Date data;

    @Column(name = "hasiera_ordua", nullable = false)
    private Time hasiera_ordua;

    @Column(name = "amaiera_ordua", nullable = false)
    private Time amaiera_ordua;

    @Column(name = "hasiera_ordua_erreala")
    private Time hasiera_ordua_erreala;

    @Column(name = "amaiera_ordua_erreala")
    private Time amaiera_ordua_erreala;

    @Column(nullable = false, length = 100)
    private String izena;

    @Column(length = 9)
    private String telefonoa;

    @Column(length = 250)
    private String deskribapena;

    @Column(nullable = false)
    private char etxekoa;

    @Column(precision = 10, scale = 2)
    private double prezio_totala;

    @ManyToOne
    @JoinColumn(name = "id_langilea")
    private Langileak langileak;

    @Embedded
    private Data dataSimple;

    // Constructor vacío
    public Hitzorduak() {}

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEserlekua() {
        return eserlekua;
    }

    public void setEserlekua(int eserlekua) {
        this.eserlekua = eserlekua;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        if (izena != null && izena.length() <= 100) {
            this.izena = izena;
        } else {
            throw new IllegalArgumentException("Izena must be non-null and up to 100 characters.");
        }
    }

    public String getTelefonoa() {
        return telefonoa;
    }

    public void setTelefonoa(String telefonoa) {
        if (telefonoa == null || telefonoa.length() == 9) {
            this.telefonoa = telefonoa;
        } else {
            throw new IllegalArgumentException("Telefonoa must be exactly 9 characters or null.");
        }
    }

    public String getDeskribapena() {
        return deskribapena;
    }

    public void setDeskribapena(String deskribapena) {
        if (deskribapena == null || deskribapena.length() <= 250) {
            this.deskribapena = deskribapena;
        } else {
            throw new IllegalArgumentException("Deskribapena must be null or up to 250 characters.");
        }
    }

    public char getEtxekoa() {
        return etxekoa;
    }

    public void setEtxekoa(char etxekoa) {
        if (etxekoa == 'E' || etxekoa == 'K') {
            this.etxekoa = etxekoa;
        } else {
            throw new IllegalArgumentException("Etxekoa must be 'E' or 'K'.");
        }
    }

    public double getPrezio_totala() {
        return prezio_totala;
    }

    public void setPrezio_totala(double prezio_totala) {
        this.prezio_totala = prezio_totala;
    }

    public Langileak getLangileak() {
        return langileak;
    }

    public void setLangileak(Langileak langileak) {
        this.langileak = langileak;
    }

    public Data getDataSimple() {
        return dataSimple;
    }

    public void setDataSimple(Data dataSimple) {
        this.dataSimple = dataSimple;
    }
}




// Eliminado: abizena / azal sentikorra / pasahitza
// Más cambios, hechos por chat GPT porque no entendía nada.

 */
