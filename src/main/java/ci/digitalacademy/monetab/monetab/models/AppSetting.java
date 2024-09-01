package ci.digitalacademy.monetab.monetab.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AppSetting")
public class AppSetting implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(name = "smtp_server")
    private String smtpServer;
    @Column(name = "smtp_port")
    private String smtpPort;
    @Column(name = "smtp_username")
    private String smtpUsername;
    @Column(name = "smtp_Password")
    private String smtpPassword;

    @OneToOne(mappedBy = "appSetting")
    private School school;
}
