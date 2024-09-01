package ci.digitalacademy.monetab.monetab.services.mappeur.impl;

import ci.digitalacademy.monetab.monetab.models.Absence;
import ci.digitalacademy.monetab.monetab.services.dto.AbsenceDTO;
import ci.digitalacademy.monetab.monetab.services.mappeur.AbsenceMApper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

@RequiredArgsConstructor
public class AbsenceMApperImpl implements AbsenceMApper {

    private final ModelMapper modelMapper;
    @Override
    public AbsenceDTO toDto(Absence entity) {
        return modelMapper.map(entity,AbsenceDTO.class);
    }

    @Override
    public Absence toEntity(AbsenceDTO dto) {
        return modelMapper.map(dto, Absence.class);
    }
}
