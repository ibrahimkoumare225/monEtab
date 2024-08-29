package ci.digitalacademy.monetab.monetab.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AppSetting")
public class AppSetting {

    @Id
    @GeneratedValue
    private  Long id;

    private String smtp_server;

    private String smtp_port;

    private String smtp_username;

    private String smtp_password;
}
