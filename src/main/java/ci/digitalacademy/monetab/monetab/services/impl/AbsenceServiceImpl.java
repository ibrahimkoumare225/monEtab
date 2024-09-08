package ci.digitalacademy.monetab.monetab.services.impl;

import ci.digitalacademy.monetab.monetab.models.Absence;
import ci.digitalacademy.monetab.monetab.repositories.AbsenceRepositories;
import ci.digitalacademy.monetab.monetab.services.AbsenceService;
import ci.digitalacademy.monetab.monetab.services.dto.AbsenceDTO;
import ci.digitalacademy.monetab.monetab.services.mappeur.AbsenceMApper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class AbsenceServiceImpl implements AbsenceService {
    private final AbsenceRepositories absenceRepositories;
    private final AbsenceMApper absenceMApper;
    @Override
    public AbsenceDTO save(AbsenceDTO absenceDTO) {
        Absence absence = absenceMApper.toEntity(absenceDTO);
        absence = absenceRepositories.save(absence);
        return absenceMApper.toDto(absence);
    }

    @Override
    public AbsenceDTO update(AbsenceDTO absenceDTO) {
        log.debug("Request to upadte absenceDTO{}", absenceDTO);
        return findOne(absenceDTO.getId()).map(existingAbsence->{
            existingAbsence.setAbsenceDate(absenceDTO.getAbsenceDate());
            existingAbsence.setAbsenceNumber(absenceDTO.getAbsenceNumber());
            return save(existingAbsence);
        }).orElseThrow(()->new IllegalArgumentException());
    }

    @Override
    public Optional<AbsenceDTO> findOne(Long id) {
        return absenceRepositories.findById(id).map(absence -> {
            return absenceMApper.toDto(absence);
        });
    }

    @Override
    public List<AbsenceDTO> findAll() {
        return absenceRepositories.findAll().stream().map(absence -> {
            return absenceMApper.toDto(absence);
        }).toList();
    }

    @Override
    public void delete(Long id) {
        absenceRepositories.deleteById(id);
    }
}
