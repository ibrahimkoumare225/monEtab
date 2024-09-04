package ci.digitalacademy.monetab.monetab.repositories;

import ci.digitalacademy.monetab.monetab.models.Professeur;
import ci.digitalacademy.monetab.monetab.models.enumerates.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfesseurRepository extends JpaRepository<Professeur,Long> {
    List<Professeur> findByNomOrMatiereAndGenre(String nom, String matiere, Gender genre);
 }
