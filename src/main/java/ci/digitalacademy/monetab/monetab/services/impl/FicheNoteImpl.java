package ci.digitalacademy.monetab.monetab.services.impl;

import ci.digitalacademy.monetab.monetab.models.Address;
import ci.digitalacademy.monetab.monetab.models.FicheNote;
import ci.digitalacademy.monetab.monetab.repositories.FicheNoteRepository;
import ci.digitalacademy.monetab.monetab.services.FicheNoteService;
import ci.digitalacademy.monetab.monetab.services.dto.FicheNoteDTO;
import ci.digitalacademy.monetab.monetab.services.mappeur.AddressMapper;
import ci.digitalacademy.monetab.monetab.services.mappeur.FicheNoteMapper;
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
    public FicheNoteDTO save(FicheNoteDTO ficheNoteDTO) {
        log.debug("Request to save : {}", ficheNoteDTO);
        FicheNote ficheNote = FicheNoteMapper.toEntity(ficheNoteDTO);
        ficheNote = ficheNoteRepository.save(ficheNote);
        return FicheNoteMapper.toDto(ficheNote);
    }

    @Override
    public FicheNoteDTO update(FicheNoteDTO ficheNoteDTO) {
        log.debug("Request update ficheNote {}",ficheNoteDTO);
        return findOne(ficheNoteDTO.getId()).map(existingFicheNote->{
            existingFicheNote.setNote(ficheNoteDTO.getNote());
            existingFicheNote.setAnnee(ficheNoteDTO.getAnnee());
            return save(existingFicheNote);
        }).orElseThrow(()->new IllegalArgumentException());
    }

    @Override
    public Optional<FicheNoteDTO> findOne(Long id) {
        log.debug("Request to find on ficheNote{}",id);
        return ficheNoteRepository.findById(id).map(ficheNote -> {
            return FicheNoteMapper.toDto(ficheNote);
        });
    }

    @Override
    public List<FicheNoteDTO> findAll() {
        log.debug("Request to find all ficheNote{}");
        return ficheNoteRepository.findAll().stream().map(ficheNote -> {
            return FicheNoteMapper.toDto(ficheNote);
        }).toList();
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete ficheNote {}",id);
        ficheNoteRepository.deleteById(id);
    }
}
