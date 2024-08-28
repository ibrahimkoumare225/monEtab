package ci.digitalacademy.monetab.monetab.services.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfesseurDTO extends PersonneDTO{

    private String matiere;

    private boolean vacant;

    public boolean getVacant() {
        return vacant;
    }
}
