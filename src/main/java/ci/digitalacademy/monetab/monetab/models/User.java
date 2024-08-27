package ci.digitalacademy.monetab.monetab.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "utilisateur")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username",unique = true,nullable = false)
    private String pseudo;

    @Column(name = "password",nullable = false)
    private String password;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "create_date",nullable = false)
    private Instant creationdate;

    @OneToOne
    private Address address;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", pseudo='" + pseudo + '\'' +
                ", password='" + password + '\'' +
                ", creationdate=" + creationdate +
                ", address=" + address.getCountry() +
                '}';
    }
}


