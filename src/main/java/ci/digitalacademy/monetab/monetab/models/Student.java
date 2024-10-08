package ci.digitalacademy.monetab.monetab.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name="student")
public class Student extends Personne{

    private String phoneNumberFather;

    private String matricule;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<Absence> absences;


}
