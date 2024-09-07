package ci.digitalacademy.monetab.monetab.models;


import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="absence")
public class Absence {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Instant absence_date;

    private int absence_number;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
