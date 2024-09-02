package ci.digitalacademy.monetab.monetab.services.mappeur;

import ci.digitalacademy.monetab.monetab.models.Absence;
import ci.digitalacademy.monetab.monetab.services.dto.AbsenceDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AbsenceMApper extends EntityMapper<AbsenceDTO, Absence>{
}
