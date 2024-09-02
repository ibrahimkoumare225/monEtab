package ci.digitalacademy.monetab.monetab.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "utilisateur")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username",unique = true,nullable = false)
    private String pseudo;

    @Column(name = "password",nullable = false)
    private String password;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "create_date",nullable = false)
    private Instant creationdate;


    @OneToMany(fetch = FetchType.EAGER)
    private Set<RoleUser> roles;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;
}


