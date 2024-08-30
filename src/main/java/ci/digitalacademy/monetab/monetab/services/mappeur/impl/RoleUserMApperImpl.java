package ci.digitalacademy.monetab.monetab.services.mappeur.impl;

import ci.digitalacademy.monetab.monetab.models.RoleUser;
import ci.digitalacademy.monetab.monetab.services.dto.RoleUserDTO;
import ci.digitalacademy.monetab.monetab.services.mappeur.RoleUserMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

@RequiredArgsConstructor
public class RoleUserMApperImpl implements RoleUserMapper {

    private final ModelMapper modelMapper;

    @Override
    public RoleUserDTO toDto(RoleUser entity) {
        return modelMapper.map(entity,RoleUserDTO.class);
    }

    @Override
    public RoleUser toEntity(RoleUserDTO dto) {
        return modelMapper.map(dto,RoleUser.class);
    }
}
