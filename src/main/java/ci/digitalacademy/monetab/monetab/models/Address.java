package ci.digitalacademy.monetab.monetab.models;

import jakarta.persistence.*;
import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "street")
    private String street;

    @Column(name="city")
    private String city;

    @Column(name = "country")
    private String country;

   @OneToOne(mappedBy = "address")
    private User user;

}
