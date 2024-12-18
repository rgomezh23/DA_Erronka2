package Models;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "kolore_historialak")
public class Kolore_historialak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int id_bezeroa;
    private int id_produktua;
    private String izena;
    private Date data;
    private String abizena;
    private int kantitatea;
    private String bolumena;
    private String oharrak;

    @Embedded
    private Data dataSimple;

    // Constructor vacío
    public Kolore_historialak() {}

    // Constructor lleno
    public Kolore_historialak(int id, int id_bezeroa, int id_produktua, String izena, Date data, String abizena,
                              int kantitatea, String bolumena, String oharrak, Data dataSimple) {
        this.id = id;
        this.id_bezeroa = id_bezeroa;
        this.id_produktua = id_produktua;
        this.izena = izena;
        this.data = data;
        this.abizena = abizena;
        this.kantitatea = kantitatea;
        this.bolumena = bolumena;
        this.oharrak = oharrak;
        this.dataSimple = dataSimple;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_bezeroa() {
        return id_bezeroa;
    }

    public void setId_bezeroa(int id_bezeroa) {
        this.id_bezeroa = id_bezeroa;
    }

    public int getId_produktua() {
        return id_produktua;
    }

    public void setId_produktua(int id_produktua) {
        this.id_produktua = id_produktua;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getAbizena() {
        return abizena;
    }

    public void setAbizena(String abizena) {
        this.abizena = abizena;
    }

    public int getKantitatea() {
        return kantitatea;
    }

    public void setKantitatea(int kantitatea) {
        this.kantitatea = kantitatea;
    }

    public String getBolumena() {
        return bolumena;
    }

    public void setBolumena(String bolumena) {
        this.bolumena = bolumena;
    }

    public String getOharrak() {
        return oharrak;
    }

    public void setOharrak(String oharrak) {
        this.oharrak = oharrak;
    }

    public Data getDataSimple() {
        return dataSimple;
    }

    public void setDataSimple(Data dataSimple) {
        this.dataSimple = dataSimple;
    }
}
