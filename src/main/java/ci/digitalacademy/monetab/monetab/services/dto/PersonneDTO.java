package ci.digitalacademy.monetab.monetab.services.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonneDTO {

    private Long id;
    private String nom;

    private String prenom;

    private String telephone;

    private String genre;

    private String ville;

    private Long age;
}
