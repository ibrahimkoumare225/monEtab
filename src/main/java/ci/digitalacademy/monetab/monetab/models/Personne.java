package ci.digitalacademy.monetab.monetab.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Personne {

    private Long id;
    private String nom;
    private String prenom;
    private String Telephone;
    private char genre;

    private String ville;

}
