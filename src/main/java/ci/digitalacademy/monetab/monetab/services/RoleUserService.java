package ci.digitalacademy.monetab.monetab.services;

import ci.digitalacademy.monetab.monetab.services.dto.RoleUserDTO;

import java.util.List;
import java.util.Optional;

public interface RoleUserService {

    RoleUserDTO save(RoleUserDTO  roleUserDTO);


    RoleUserDTO  update(RoleUserDTO  roleUserDTO);


    Optional<RoleUserDTO > findOne(Long id);

    List<RoleUserDTO > findAll();

    void delete(Long id);
}
