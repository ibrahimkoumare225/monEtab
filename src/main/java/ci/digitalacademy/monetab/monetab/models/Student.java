package ci.digitalacademy.monetab.monetab.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name="student")
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "classe",nullable = false)
    private String classe;

    @Column(name = "matricule",nullable = false)
    private String matricule;

}
