package ci.digitalacademy.monetab.monetab.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "studentCard")
public class StudentCards {

    @Id
    @GeneratedValue
    private  Long id;

    private String reference;

    private String issue_date;

    private Date expiration_date;

    @ManyToOne
    private Student student;

}
