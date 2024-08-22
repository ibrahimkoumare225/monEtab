package ci.digitalacademy.monetab.monetab.services.impl;

import ci.digitalacademy.monetab.monetab.models.Professeur;
import ci.digitalacademy.monetab.monetab.repositories.ProfesseurRepository;
import ci.digitalacademy.monetab.monetab.services.ProfesseurService;
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
    @Override
    public Professeur save(Professeur professeur) {
        return professeurRepository.save(professeur);
    }

    @Override
    public Professeur update(Professeur professeur) {
        log.debug("Request to upadte professeur{}",professeur);
        Optional<Professeur> optionalProfesseur = findOne(professeur.getId());
        if(optionalProfesseur.isPresent()){
            Professeur professeurToUpdate = optionalProfesseur.get();
            professeurToUpdate.setMatiere(professeur.getMatiere());
            return save(professeurToUpdate);
        }else{
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Optional<Professeur> findOne(Long id) {
        log.debug("Request to find on professeur{}",id);
        return professeurRepository.findById(id);
    }

    @Override
    public List<Professeur> findAll() {
        log.debug("Request to find all professeur ");
        return professeurRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete professeur {}",id);
        professeurRepository.deleteById(id);
    }
}
