package ci.digitalacademy.monetab.monetab.services.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class StudentCardsDTO {
    private  Long id;

    private String reference;

    private String issue_date;

    private Date expirationDate;
}
