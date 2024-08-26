package ci.digitalacademy.monetab.monetab.models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity(name = "ficheNote")
public class FicheNote {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

    @Column(name = "note")
    private double note;
    @Column(name="annee")
     private int annee;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "professeur_id")
    private Professeur professeur;

    @Override
    public String toString() {
        return "FicheNote{" +
                "id=" + id +
                ", note=" + note +
                ", annee=" + annee +
                ", professeur=" + professeur +
                '}';
    }
}
