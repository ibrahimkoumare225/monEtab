package ci.digitalacademy.monetab.monetab.models;

import ci.digitalacademy.monetab.monetab.models.enumerates.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

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

    @Column(name="phone_number",unique = true)
    private String telephone;

    @Enumerated(value = EnumType.STRING)
    private Gender genre;

    @Column(name="city",nullable = false)
    private String ville;

    @Column(name="age",nullable = false)
    private Instant age;

    @OneToOne
    private  Address address;

}
