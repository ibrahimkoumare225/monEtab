package ci.digitalacademy.monetab.monetab.services.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;


@Getter
@Setter
public class RegistrationSchoolDTO extends SchoolDTO {

    private MultipartFile file;
}
