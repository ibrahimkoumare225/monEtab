package ci.digitalacademy.monetab.monetab.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="professeur")
public class Professeur {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "matiere",nullable = false)
    private String matiere;

    @Column(name = "vacant",nullable = false)
    private boolean vacant;


}
