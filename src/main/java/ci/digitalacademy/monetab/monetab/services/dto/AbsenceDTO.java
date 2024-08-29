package ci.digitalacademy.monetab.monetab.services.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AbsenceDTO {
    private Long id;

    private Date absence_date;

    private int absence_number;
}
