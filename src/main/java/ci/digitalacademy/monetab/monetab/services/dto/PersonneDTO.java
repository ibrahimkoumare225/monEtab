package ci.digitalacademy.monetab.monetab.services.dto;

import ci.digitalacademy.monetab.monetab.models.Address;
import ci.digitalacademy.monetab.monetab.models.User;
import ci.digitalacademy.monetab.monetab.models.enumerates.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonneDTO {

    private Long id;

    private String nom;

    private String prenom;

    private String telephone;

    private Gender genre;

    String urlPicture;

    private String birthday;

    private Address address;

    private User user;
}
