package ci.digitalacademy.monetab.monetab.services;

import ci.digitalacademy.monetab.monetab.models.FicheNote;
import ci.digitalacademy.monetab.monetab.services.impl.FicheNoteImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface FicheNoteService {

    FicheNote save(FicheNote ficheNote);

    FicheNote update(FicheNote ficheNote);

    Optional<FicheNote> findOne(Long id);

    List<FicheNote> findAll();
    void delete(Long id);
}
