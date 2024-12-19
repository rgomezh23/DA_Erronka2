package e2;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Zerbitzuak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String izena;
    private String deskribapena;
    private double prezioa;
    
    @Column(name = "sortze_data", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime sortzeData;
    
    @Column(name = "eguneratze_data", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime eguneratzeData;
    
    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData;

    // Getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getIzena() {
        return izena;
    }
    public void setIzena(String izena) {
        this.izena = izena;
    }
    public String getDeskribapena() {
        return deskribapena;
    }
    public void setDeskribapena(String deskribapena) {
        this.deskribapena = deskribapena;
    }
    public double getPrezioa() {
        return prezioa;
    }
    public void setPrezioa(double prezioa) {
        this.prezioa = prezioa;
    }
    public LocalDateTime getSortzeData() {
        return sortzeData;
    }
    public void setSortzeData(LocalDateTime sortzeData) {
        this.sortzeData = sortzeData;
    }
    public LocalDateTime getEguneratzeData() {
        return eguneratzeData;
    }
    public void setEguneratzeData(LocalDateTime eguneratzeData) {
        this.eguneratzeData = eguneratzeData;
    }
    public LocalDateTime getEzabatzeData() {
        return ezabatzeData;
    }
    public void setEzabatzeData(LocalDateTime ezabatzeData) {
        this.ezabatzeData = ezabatzeData;
    }
}
