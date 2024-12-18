package Models;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hitzorduak")
public class Hitzorduak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String pasahitza;
    private String izena;
    private String abizena;
    private int eserlekua;
    private String telefonoa;
    private String deskribapena;
    private char etxekoa;
    private double prezio_totala;
    private int id_langilea;
    private boolean azal_sentikorra;

    @Embedded
    private Denbora denbora;

    @Embedded
    private Data data;

    public Hitzorduak(int id, String pasahitza, String izena, String abizena, int eserlekua, String telefonoa,
            String deskribapena, char etxekoa, double prezio_totala, int id_langilea, boolean azal_sentikorra,
            Denbora denbora, Data data) {
        this.id = id;
        this.pasahitza = pasahitza;
        this.izena = izena;
        this.abizena = abizena;
        this.eserlekua = eserlekua;
        this.telefonoa = telefonoa;
        this.deskribapena = deskribapena;
        this.etxekoa = etxekoa;
        this.prezio_totala = prezio_totala;
        this.id_langilea = id_langilea;
        this.azal_sentikorra = azal_sentikorra;
        this.denbora = denbora;
        this.data = data;
    }

    public Hitzorduak() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPasahitza() {
        return pasahitza;
    }

    public void setPasahitza(String pasahitza) {
        this.pasahitza = pasahitza;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public String getAbizena() {
        return abizena;
    }

    public void setAbizena(String abizena) {
        this.abizena = abizena;
    }

    public int getEserlekua() {
        return eserlekua;
    }

    public void setEserlekua(int eserlekua) {
        this.eserlekua = eserlekua;
    }

    public String getTelefonoa() {
        return telefonoa;
    }

    public void setTelefonoa(String telefonoa) {
        this.telefonoa = telefonoa;
    }

    public String getDeskribapena() {
        return deskribapena;
    }

    public void setDeskribapena(String deskribapena) {
        this.deskribapena = deskribapena;
    }

    public char getEtxekoa() {
        return etxekoa;
    }

    public void setEtxekoa(char etxekoa) {
        this.etxekoa = etxekoa;
    }

    public double getPrezio_totala() {
        return prezio_totala;
    }

    public void setPrezio_totala(double prezio_totala) {
        this.prezio_totala = prezio_totala;
    }

    public int getId_langilea() {
        return id_langilea;
    }

    public void setId_langilea(int id_langilea) {
        this.id_langilea = id_langilea;
    }

    public boolean isAzal_sentikorra() {
        return azal_sentikorra;
    }

    public void setAzal_sentikorra(boolean azal_sentikorra) {
        this.azal_sentikorra = azal_sentikorra;
    }

    public Denbora getDenbora() {
        return denbora;
    }

    public void setDenbora(Denbora denbora) {
        this.denbora = denbora;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
