package ci.digitalacademy.monetab.monetab.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="school")
public class School {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "nom",nullable = false)
    private String name;

    @Column(name = "url_logo",nullable = false)
    private String url_logo;

    @ManyToOne
    private School school;

    @OneToOne
    private AppSetting appSetting;
}
