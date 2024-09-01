package ci.digitalacademy.monetab.monetab.services.impl;

import ci.digitalacademy.monetab.monetab.services.AppSettingService;
import ci.digitalacademy.monetab.monetab.services.dto.AppSettingDTO;
import ci.digitalacademy.monetab.monetab.services.mappeur.AppSettingMaapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class AppSettingServiceImpl implements AppSettingService {

    private final AppSettingService appSettingService;

    private  final AppSettingMaapper  appSettingMaapper;

    @Override
    public AppSettingDTO save(AppSettingDTO AppSettingDTO) {
        return null;
    }

    @Override
    public AppSettingDTO update(AppSettingDTO AppSettingDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<AppSettingDTO> findAll() {
        return null;
    }

    @Override
    public Optional<AppSettingDTO> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public List<AppSettingDTO> findAllBySmtpUsername(String smtpUsername) {
        return null;
    }
}
