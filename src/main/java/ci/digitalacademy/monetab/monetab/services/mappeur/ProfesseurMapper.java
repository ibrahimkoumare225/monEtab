package ci.digitalacademy.monetab.monetab.services.mappeur;

import ci.digitalacademy.monetab.monetab.models.Professeur;
import ci.digitalacademy.monetab.monetab.services.dto.ProfesseurDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfesseurMapper extends EntityMapper<ProfesseurDTO, Professeur>{
}
