package Models;

import java.sql.Time;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordugetiak")
public class Ordugetiak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String kodea;
    private int eguna;
    private Time hasiera_ordua;
    private Time amaiera_ordua;
    

    @Embedded
    private Data data;
    
    @Embedded
    private Denbora denbora;
    


	public Ordugetiak() {}
}
