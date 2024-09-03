package ci.digitalacademy.monetab.monetab.services.impl;

import ci.digitalacademy.monetab.monetab.models.RoleUser;
import ci.digitalacademy.monetab.monetab.repositories.RoleUserRepositories;
import ci.digitalacademy.monetab.monetab.services.RoleUserService;
import ci.digitalacademy.monetab.monetab.services.dto.RoleUserDTO;
import ci.digitalacademy.monetab.monetab.services.mappeur.RoleUserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoleUserServiceImpl implements RoleUserService {

    private final RoleUserRepositories roleUserRepositories;
    private  final RoleUserMapper roleUserMapper;

    @Override
    public RoleUserDTO save(RoleUserDTO roleUserDTO) {
        RoleUser roleUser = roleUserMapper.toEntity(roleUserDTO);
        roleUser = roleUserRepositories.save(roleUser);
        return roleUserMapper.toDto(roleUser);
    }

    @Override
    public List<RoleUserDTO> initRoles(List<RoleUserDTO> roleUsers) {
        log.debug("Request to init roles {}", roleUsers);
        List<RoleUserDTO> roles = findAll();
        if (roles.isEmpty()){
            roleUsers.forEach(role->{
                save(role);
            });
        }
        return findAll();

    }

    @Override
    public RoleUserDTO update(RoleUserDTO roleUserDTO) {
        log.debug("Request to upadte schoolDTO{}",roleUserDTO);
        return findOne(roleUserDTO.getId()).map(existingRoleUser->{
            existingRoleUser.setNameRole(roleUserDTO.getNameRole());
            return save(existingRoleUser);
        }).orElseThrow(()->new IllegalArgumentException());
    }

    @Override
    public Optional<RoleUserDTO> findOne(Long id) {
        log.debug("Request to find on user {}",id);
        return roleUserRepositories.findById(id).map(roleUser -> {
            return roleUserMapper.toDto(roleUser);
        });
    }

    @Override
    public List<RoleUserDTO> findAll() {
        return roleUserRepositories.findAll().stream().map(roleUser -> {
            return roleUserMapper.toDto(roleUser);
        }).toList();
    }

    @Override
    public void delete(Long id) {
       roleUserRepositories.deleteById(id);
    }
}
