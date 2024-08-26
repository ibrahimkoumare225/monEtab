package ci.digitalacademy.monetab.monetab.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@DiscriminatorValue(value="professeur")
@Entity(name="professeur")
public class Professeur extends Personne{

    @Column(name = "matiere",nullable = false)
    private String matiere;

    @Column(name = "vacant",nullable = false)
    private boolean vacant;

    /*@OneToMany(fetch = FetchType.EAGER,mappedBy = "professeur")
    private Set<FicheNote> ficheNotes;

    @Override
    public String toString() {
        return "Professeur{" +
                "id=" + id +
                ", matiere='" + matiere + '\'' +
                ", vacant=" + vacant +
                 '}';
    }*/
}
