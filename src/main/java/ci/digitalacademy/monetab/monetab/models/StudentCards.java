package ci.digitalacademy.monetab.monetab.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "studentCard")
public class StudentCards {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    private String reference;

    private String issueDate;

    private Instant expirationDate;

    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;

}
