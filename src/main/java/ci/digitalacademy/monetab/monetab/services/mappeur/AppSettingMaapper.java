package ci.digitalacademy.monetab.monetab.services.mappeur;

import ci.digitalacademy.monetab.monetab.models.AppSetting;
import ci.digitalacademy.monetab.monetab.services.dto.AppSettingDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppSettingMaapper extends EntityMapper<AppSettingDTO, AppSetting>{
}
