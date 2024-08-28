package ci.digitalacademy.monetab.monetab.services.dto;

import ci.digitalacademy.monetab.monetab.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AddressDTO {

    private Long id;

    private String street;

    private String city;

    private String country;

    private User user;
}
