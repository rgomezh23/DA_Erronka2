package e2;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TicketLerroak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String izena;
    
    @ManyToOne
    @JoinColumn(name = "id_zerbitzua", nullable = false)
    private Zerbitzuak zerbitzuak;
    
    @ManyToOne
    @JoinColumn(name = "id_langilea", nullable = false)
    private Langileak langileak;
    
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
    public Zerbitzuak getZerbitzuak() {
        return zerbitzuak;
    }
    public void setZerbitzuak(Zerbitzuak zerbitzuak) {
        this.zerbitzuak = zerbitzuak;
    }
    public Langileak getLangileak() {
        return langileak;
    }
    public void setLangileak(Langileak langileak) {
        this.langileak = langileak;
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
