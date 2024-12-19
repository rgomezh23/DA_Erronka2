package e2;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Txandak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String mota;
    private Date data;
    
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
    public String getMota() {
        return mota;
    }
    public void setMota(String mota) {
        this.mota = mota;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
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
