package ci.digitalacademy.monetab.monetab.services.impl;

import ci.digitalacademy.monetab.monetab.models.Professeur;
import ci.digitalacademy.monetab.monetab.models.enumerates.Gender;
import ci.digitalacademy.monetab.monetab.repositories.ProfesseurRepository;
import ci.digitalacademy.monetab.monetab.services.ProfesseurService;
import ci.digitalacademy.monetab.monetab.services.dto.ProfesseurDTO;
import ci.digitalacademy.monetab.monetab.services.mappeur.ProfesseurMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@RequiredArgsConstructor
@Service
public class ProfesseurServiceImpl implements ProfesseurService {

    private final ProfesseurRepository professeurRepository;
    private  final ProfesseurMapper professeurMapper;
    @Override
    public ProfesseurDTO save(ProfesseurDTO professeurDTO) {
        log.debug("Request to save : {}", professeurDTO);
        Professeur professeur = professeurMapper.toEntity(professeurDTO);
        professeur = professeurRepository.save(professeur);
        return professeurMapper.toDto(professeur);
    }

    @Override
    public ProfesseurDTO update(ProfesseurDTO professeurDTO) {
        log.debug("Request to upadte professeur{}",professeurDTO);
        return findOne(professeurDTO.getId()).map(existingProfesseur->{
            existingProfesseur.setNom(professeurDTO.getNom());
            existingProfesseur.setPrenom(professeurDTO.getPrenom());
            return save(existingProfesseur);
        }).orElseThrow(()->new IllegalArgumentException());

    }

    @Override
    public Optional<ProfesseurDTO> findOne(Long id) {
        log.debug("Request to find on professeur{}",id);
        return professeurRepository.findById(id).map(professeur -> {
            return professeurMapper.toDto(professeur);
        });
    }

    @Override
    public List<ProfesseurDTO> findAll() {
        log.debug("Request to find all professeur ");
        return professeurRepository.findAll().stream().map(professeur -> {
            return professeurMapper.toDto(professeur);
        }).toList();
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete professeur {}",id);
        professeurRepository.deleteById(id);
    }

    @Override
    public List<ProfesseurDTO> findByNomOrMatiereAndGenre(String query, String genre) {
        List<Professeur> teachers = professeurRepository.findByNomOrMatiereAndGenre(query , query ,  Gender.valueOf(genre));
        return teachers.stream().map(teacher -> professeurMapper.toDto(teacher)).toList();
    }
}
