package ci.digitalacademy.monetab.monetab.services.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleUserDTO {

    private Long id;
    private String role;
}
