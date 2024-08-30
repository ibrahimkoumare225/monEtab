package ci.digitalacademy.monetab.monetab.services.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppSettingDTO {

    private  Long id;

    private String smtpServer;

    private String smtpPort;

    private String smtpUsername;

    private String smtpPassword;
}
