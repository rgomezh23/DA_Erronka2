package eus.fpsanturtzilh.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name = "taldeak")
public class Taldeak {
    @Id
    private String kodea;
    private String izena;

    @Embedded
    private Data data;
    
    @OneToMany(mappedBy = "taldeak", cascade = CascadeType.ALL) 
    @JsonManagedReference
    private List<Langileak> langileak;
}
