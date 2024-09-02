package ci.digitalacademy.monetab.monetab.services.impl;

import ci.digitalacademy.monetab.monetab.models.AppSetting;
import ci.digitalacademy.monetab.monetab.repositories.AppSettingRepositories;
import ci.digitalacademy.monetab.monetab.services.AppSettingService;
import ci.digitalacademy.monetab.monetab.services.dto.AppSettingDTO;
import ci.digitalacademy.monetab.monetab.services.mappeur.AppSettingMaapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AppSettingServiceImpl implements AppSettingService {

    private final AppSettingRepositories appSettingRepositories;

    private  final AppSettingMaapper  appSettingMaapper;

    @Override
    public AppSettingDTO save(AppSettingDTO appSettingDTO) {
        AppSetting appSetting = appSettingMaapper.toEntity(appSettingDTO);
        appSetting = appSettingRepositories.save(appSetting);
        return appSettingMaapper.toDto(appSetting);
    }

    @Override
    public AppSettingDTO update(AppSettingDTO appSettingDTO) {

        log.debug("Request to upadte appSettingDTO{}",appSettingDTO);
        return findOne(appSettingDTO.getId()).map(existingSchool->{
            existingSchool.setSmtpPort(appSettingDTO.getSmtpPort());
            existingSchool.setSmtpServer(appSettingDTO.getSmtpServer());
            return save(existingSchool);
        }).orElseThrow(()->new IllegalArgumentException());
    }

    @Override
    public void delete(Long id) {
        appSettingRepositories.deleteById(id);
    }

    @Override
    public List<AppSettingDTO> findAll() {
        return appSettingRepositories.findAll().stream().map(appSetting -> {
                return appSettingMaapper.toDto(appSetting);
        }).toList();
    }

    @Override
    public Optional<AppSettingDTO> findOne(Long id) {

        return appSettingRepositories.findById(id).map(appSetting -> {
            return appSettingMaapper.toDto(appSetting);
        });
    }

    @Override
    public List<AppSettingDTO> findAllBySmtpUsername(String smtpUsername) {
        return null;
    }

    @Override
    public AppSettingDTO initApp(AppSettingDTO appSettingDTO) {
        log.debug("Request to init app {}",appSettingDTO);
        AppSettingDTO appSetting = existingParameter();
        if(appSetting == null){
            save(appSettingDTO);
        }
        return  appSetting;
    }

    @Override
    public AppSettingDTO existingParameter() {
        List<AppSettingDTO> appSettingDTO = findAll();
        return appSettingDTO.stream().findFirst().orElse(null);
    }


}
