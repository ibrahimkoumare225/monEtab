package ci.digitalacademy.monetab.monetab.repositories;

import ci.digitalacademy.monetab.monetab.models.AppSetting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppSettingRepositories extends JpaRepository<AppSetting,Long> {
    List<AppSetting> findBySmtpUsername(String username);
}
