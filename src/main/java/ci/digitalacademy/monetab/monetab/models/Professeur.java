package ci.digitalacademy.monetab.monetab.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@ToString
@Entity(name="professeur")
public class Professeur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "matiere",nullable = false)
    private String matiere;

    @Column(name = "vacant",nullable = false)
    private boolean vacant;

    @OneToMany
    private Set<FicheNote> ficheNotes;
}
