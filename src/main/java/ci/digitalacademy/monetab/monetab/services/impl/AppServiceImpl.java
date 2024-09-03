package ci.digitalacademy.monetab.monetab.services.impl;

import ci.digitalacademy.monetab.monetab.services.*;
import ci.digitalacademy.monetab.monetab.services.dto.AppSettingDTO;
import ci.digitalacademy.monetab.monetab.services.dto.RoleUserDTO;
import ci.digitalacademy.monetab.monetab.services.dto.SchoolDTO;
import ci.digitalacademy.monetab.monetab.services.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AppServiceImpl implements AppService {


    @Autowired
    private AppSettingService appSettingService;

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private RoleUserService roleUserService;

    @Autowired
    private UserService userService;

    public AppSettingDTO initApp(AppSettingDTO appSettingDTO) {
        return appSettingService.initApp(appSettingDTO);
    }

    @Override
    public SchoolDTO initSchool(SchoolDTO schoolDTO, AppSettingDTO appSettingDTO) {
        schoolDTO.setAppSetting(appSettingDTO);
        return schoolService.initSchool(schoolDTO);
    }

    @Override
    public List<RoleUserDTO> initRoleUsers(List<RoleUserDTO> roleUserDTOList) {
        return roleUserService.initRoles(roleUserDTOList);
    }


    @Override
    public void initUsers(List<RoleUserDTO> roleUserDTO, List<UserDTO> userDTO, SchoolDTO schoolDto) {

    }

}
