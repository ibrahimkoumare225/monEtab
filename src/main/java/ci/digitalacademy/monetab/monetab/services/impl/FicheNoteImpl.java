package ci.digitalacademy.monetab.monetab.services.impl;

import ci.digitalacademy.monetab.monetab.models.FicheNote;
import ci.digitalacademy.monetab.monetab.repositories.FicheNoteRepository;
import ci.digitalacademy.monetab.monetab.services.FicheNoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Slf4j
@RequiredArgsConstructor
public class FicheNoteImpl implements FicheNoteService {
    private final FicheNoteRepository ficheNoteRepository;

    @Override
    public FicheNote save(FicheNote ficheNote) {
        return ficheNoteRepository.save(ficheNote);
    }

    @Override
    public FicheNote update(FicheNote ficheNote) {
        log.debug("Request to upadte ficheNote{}",ficheNote);
        Optional<FicheNote> optionalFicheNote = findOne(ficheNote.getId());
        if(optionalFicheNote.isPresent()){
            FicheNote ficheNoteToUpdate = optionalFicheNote.get();
            ficheNoteToUpdate.setNote(ficheNote.getNote());
            return save(ficheNoteToUpdate);
        }else{
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Optional<FicheNote> findOne(Long id) {
        log.debug("Request to find on ficheNote{}",id);
        return ficheNoteRepository.findById(id);
    }

    @Override
    public List<FicheNote> findAll() {
        log.debug("Request to find all ficheNote{}");
        return ficheNoteRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete ficheNote {}",id);
        ficheNoteRepository.deleteById(id);
    }
}
