package ci.digitalacademy.monetab.monetab.services.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;


@Getter
@Setter
public class AbsenceDTO {
    private Long id;

    private Instant absence_date;

    private int absence_number;
}
