package ci.digitalacademy.monetab.monetab.services.dto;

import ci.digitalacademy.monetab.monetab.models.Student;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Date;

@Getter
@Setter
public class StudentCardsDTO {
    private  Long id;

    private String reference;

    private String issueDate;

    private Instant expirationDate;

    private Student student;
}
