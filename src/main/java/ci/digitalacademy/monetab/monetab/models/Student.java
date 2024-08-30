package ci.digitalacademy.monetab.monetab.models;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@DiscriminatorValue(value = "student")
@Entity(name="student")
public class Student extends Personne{

    @Column(name = "classe",nullable = false)
    private String classe;

    @Column(name = "matricule",nullable = false)
    private String matricule;



}
