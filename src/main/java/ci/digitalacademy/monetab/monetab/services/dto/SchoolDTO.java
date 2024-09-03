package ci.digitalacademy.monetab.monetab.services.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SchoolDTO {

    private Long id;
    private String nameSchool;
    private String url_logo;

    private AppSettingDTO appSetting;
}

