package ci.digitalacademy.monetab.monetab.services.mappeur.impl;

import ci.digitalacademy.monetab.monetab.models.AppSetting;
import ci.digitalacademy.monetab.monetab.services.dto.AppSettingDTO;
import ci.digitalacademy.monetab.monetab.services.mappeur.AppSettingMaapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

@RequiredArgsConstructor
public class AppSettingMApperImpl implements AppSettingMaapper {

    private final ModelMapper modelMapper;

    @Override
    public AppSettingDTO toDto(AppSetting entity) {
        return modelMapper.map(entity,AppSettingDTO.class);
    }

    @Override
    public AppSetting toEntity(AppSettingDTO dto) {
        return modelMapper.map(dto,AppSetting.class);
    }
}
