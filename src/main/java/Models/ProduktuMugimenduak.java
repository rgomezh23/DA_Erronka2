package e2;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ProduktuMugimenduak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "id_produktua", nullable = false)
    private Produktuak produktuak;
    
    private String mota;
    private double kantitatea;
    
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
    public Produktuak getProduktuak() {
        return produktuak;
    }
    public void setProduktuak(Produktuak produktuak) {
        this.produktuak = produktuak;
    }
    public String getMota() {
        return mota;
    }
    public void setMota(String mota) {
        this.mota = mota;
    }
    public double getKantitatea() {
        return kantitatea;
    }
    public void setKantitatea(double kantitatea) {
        this.kantitatea = kantitatea;
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
