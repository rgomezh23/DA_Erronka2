package e2;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Taldeak {
    @Id
    private String kodea;
    
    private String izena;
    
    @Column(name = "sortze_data", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime sortzeData;
    
    @Column(name = "eguneratze_data", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime eguneratzeData;
    
    @Column(name = "ezabatze_data")
    private LocalDateTime ezabatzeData;

    // Getters and setters
    public String getKodea() {
        return kodea;
    }
    public void setKodea(String kodea) {
        this.kodea = kodea;
    }
    public String getIzena() {
        return izena;
    }
    public void setIzena(String izena) {
        this.izena = izena;
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
