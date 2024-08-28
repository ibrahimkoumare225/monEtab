package ci.digitalacademy.monetab.monetab.services;

import ci.digitalacademy.monetab.monetab.models.FicheNote;
import ci.digitalacademy.monetab.monetab.services.dto.FicheNoteDTO;
import ci.digitalacademy.monetab.monetab.services.impl.FicheNoteImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface FicheNoteService {

    FicheNoteDTO save(FicheNoteDTO ficheNoteDTO);

    FicheNoteDTO update(FicheNoteDTO ficheNoteDTO);

    Optional<FicheNoteDTO> findOne(Long id);

    List<FicheNoteDTO> findAll();
    void delete(Long id);
}
