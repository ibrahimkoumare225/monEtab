package ci.digitalacademy.monetab.monetab.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name="absence")
public class Absence {

    @Id
    @GeneratedValue
    private Long id;

    private Date  absence_date;

    private int absence_number;
}
