package ci.digitalacademy.monetab.monetab.services.mappeur.impl;

import ci.digitalacademy.monetab.monetab.models.Professeur;
import ci.digitalacademy.monetab.monetab.services.dto.ProfesseurDTO;
import ci.digitalacademy.monetab.monetab.services.mappeur.ProfesseurMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProfesseurMapperImpl implements ProfesseurMapper {
    private final ModelMapper modelMapper;
    @Override
    public ProfesseurDTO toDto(Professeur entity) {
        return modelMapper.map(entity,ProfesseurDTO.class);
    }

    @Override
    public Professeur toEntity(ProfesseurDTO dto) {
        return modelMapper.map(dto,Professeur.class);
    }
}
