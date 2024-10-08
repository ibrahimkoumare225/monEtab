package ci.digitalacademy.monetab.monetab.services.dto;

import ci.digitalacademy.monetab.monetab.models.Absence;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class StudentDTO extends PersonneDTO{

    private String phoneNumberFather;

    private String matricule;

    private Set<Absence> absences;
}
