package ci.digitalacademy.monetab.monetab.services.mappeur;

import ci.digitalacademy.monetab.monetab.models.StudentCards;
import ci.digitalacademy.monetab.monetab.services.dto.StudentCardsDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentCardsMapper extends EntityMapper<StudentCardsDTO, StudentCards>{
}
