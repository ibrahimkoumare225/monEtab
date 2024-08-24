package ci.digitalacademy.monetab.monetab.models;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@ToString
@Entity(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "classe",nullable = false)
    private String classe;

    @Column(name = "matricule",nullable = false)
    private String matricule;

}
