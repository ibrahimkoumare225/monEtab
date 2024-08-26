package ci.digitalacademy.monetab.monetab.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name = "person_type")
@Getter
@Setter
@Entity
@Table(name = "personne")
public abstract class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="first_name",nullable = false)
    private String nom;

    @Column(name="last_name",nullable = false)
    private String prenom;

    @Column(name="phone",nullable = false)
    private String telephone;

    @Column(name="gend",nullable = false)
    private char genre;

    @Column(name="city",nullable = false)
    private String ville;

    @Column(name="age",nullable = false)
    private Long age;



}
