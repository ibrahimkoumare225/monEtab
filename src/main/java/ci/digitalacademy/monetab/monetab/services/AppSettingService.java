package ci.digitalacademy.monetab.monetab.services;

import ci.digitalacademy.monetab.monetab.models.AppSetting;
import ci.digitalacademy.monetab.monetab.services.dto.AppSettingDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AppSettingService {


    AppSettingDTO save(AppSettingDTO AppSettingDTO);

    AppSettingDTO update(AppSettingDTO AppSettingDTO);

    void delete(Long id);
    List<AppSettingDTO> findAll();

    Optional<AppSettingDTO> findOne(Long id);

    List<AppSettingDTO> findAllBySmtpUsername(String smtpUsername);

    public AppSettingDTO initApp(AppSettingDTO appSettingDTO);

    public AppSettingDTO existingParameter();

}
