package ci.digitalacademy.monetab.monetab.models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@ToString
@Entity(name = "ficheNote")
public class FicheNote {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

    @Column(name = "note")
    private double note;
    @Column(name="annee")
     private int annee;
    /*@ManyToOne
    @JoinColumn(name = "professeur_id")
    private Professeur professeur;*/
}
