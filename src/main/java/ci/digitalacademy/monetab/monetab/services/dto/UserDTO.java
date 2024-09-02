package ci.digitalacademy.monetab.monetab.services.dto;

import ci.digitalacademy.monetab.monetab.models.RoleUser;
import ci.digitalacademy.monetab.monetab.models.School;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.util.Set;


@Setter
@Getter
public class UserDTO {
    private Long id;

    private String pseudo;

    private String password;

    private Instant creationdate;

    private Set<RoleUserDTO> roles;


    private SchoolDTO school;

}
