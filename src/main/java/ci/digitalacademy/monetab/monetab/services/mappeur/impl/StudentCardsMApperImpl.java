package ci.digitalacademy.monetab.monetab.services.mappeur.impl;

import ci.digitalacademy.monetab.monetab.models.StudentCards;
import ci.digitalacademy.monetab.monetab.services.dto.StudentCardsDTO;
import ci.digitalacademy.monetab.monetab.services.mappeur.StudentCardsMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;


@RequiredArgsConstructor
public class StudentCardsMApperImpl implements StudentCardsMapper {

    private final ModelMapper modelMapper;
    @Override
    public StudentCardsDTO toDto(StudentCards entity) {
        return modelMapper.map(entity,StudentCardsDTO.class);
    }

    @Override
    public StudentCards toEntity(StudentCardsDTO dto) {
        return modelMapper.map(dto,StudentCards.class);
    }
}
