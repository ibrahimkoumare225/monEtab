package ci.digitalacademy.monetab.monetab.services;

import ci.digitalacademy.monetab.monetab.models.Professeur;
import ci.digitalacademy.monetab.monetab.services.dto.ProfesseurDTO;

import java.util.List;
import java.util.Optional;

public interface ProfesseurService {

    ProfesseurDTO save(ProfesseurDTO professeurDTO);
    ProfesseurDTO update(ProfesseurDTO professeurDTO);

    Optional<ProfesseurDTO> findOne(Long id);

    List<ProfesseurDTO> findAll();
    void delete(Long id);
}
