package ci.digitalacademy.monetab.monetab.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="absence")
public class Absence {

    @Id
    @GeneratedValue
    private Long id;

    private Date  absence_date;

    private int absence_number;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
