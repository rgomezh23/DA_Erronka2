package Models;

import java.sql.Date;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordutegiak")
public class Ordutegiak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String kodea;
    private int eguna;
    private Date hasiera_data;
    private Date amaiera_data;
    

    @Embedded
    private Data data;
    
    @Embedded
    private Denbora denbora;
    


	public Ordutegiak() {}
}
