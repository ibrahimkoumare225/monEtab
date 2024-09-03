package ci.digitalacademy.monetab.monetab.services;

import ci.digitalacademy.monetab.monetab.services.dto.AppSettingDTO;
import ci.digitalacademy.monetab.monetab.services.dto.RoleUserDTO;
import ci.digitalacademy.monetab.monetab.services.dto.SchoolDTO;
import ci.digitalacademy.monetab.monetab.services.dto.UserDTO;

import java.util.List;

public interface AppService {

    SchoolDTO initSchool(SchoolDTO schoolDTO , AppSettingDTO appSettingDTO);
    List<RoleUserDTO> initRoleUsers(List<RoleUserDTO> roleUserDTOList);
    AppSettingDTO initApp(AppSettingDTO    appSettingDTO);

    void initUsers(List<RoleUserDTO> roleUserDTO, List<UserDTO> userDTO,SchoolDTO schoolDto);
}
