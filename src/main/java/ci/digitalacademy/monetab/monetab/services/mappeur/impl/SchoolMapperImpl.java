package ci.digitalacademy.monetab.monetab.services.mappeur.impl;

import ci.digitalacademy.monetab.monetab.models.School;
import ci.digitalacademy.monetab.monetab.services.dto.SchoolDTO;
import ci.digitalacademy.monetab.monetab.services.mappeur.SchoolMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

@RequiredArgsConstructor
public class SchoolMapperImpl implements SchoolMapper {

    private final ModelMapper modelMapper;
    @Override
    public SchoolDTO toDto(School entity) {
        return modelMapper.map(entity, SchoolDTO.class);
    }

    @Override
    public School toEntity(SchoolDTO dto) {
        return modelMapper.map(dto,School.class);
    }
}
