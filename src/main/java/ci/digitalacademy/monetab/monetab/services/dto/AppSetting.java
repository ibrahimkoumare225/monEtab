package ci.digitalacademy.monetab.monetab.services.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppSetting {

    private  Long id;

    private String smtp_server;

    private String smtp_port;

    private String smtp_username;

    private String smtp_password;
}
