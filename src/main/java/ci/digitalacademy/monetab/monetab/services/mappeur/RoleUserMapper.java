package ci.digitalacademy.monetab.monetab.services.mappeur;


import ci.digitalacademy.monetab.monetab.models.RoleUser;
import ci.digitalacademy.monetab.monetab.services.dto.RoleUserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleUserMapper extends EntityMapper<RoleUserDTO, RoleUser> {
}
