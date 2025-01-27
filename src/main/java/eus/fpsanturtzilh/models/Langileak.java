package eus.fpsanturtzilh.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "langileak")
public class Langileak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String izena;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "kodea", referencedColumnName = "kodea", nullable = false)
    private Taldeak taldeak; // La relación ManyToOne ya mapea 'kodea'

    // berdinak ez isateko
    @Column(name = "kodea", nullable= false, insertable = false, updatable = false)
    private String kode; 

    private String abizenak;

    @Embedded
    private Data data;
}
