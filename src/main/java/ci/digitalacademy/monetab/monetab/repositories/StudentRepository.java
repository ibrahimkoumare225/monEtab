package ci.digitalacademy.monetab.monetab.repositories;

import ci.digitalacademy.monetab.monetab.models.Student;
import ci.digitalacademy.monetab.monetab.models.enumerates.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByNomIgnoreCaseOrMatriculeIgnoreCaseAndGenre(String nom, String matricule , Gender genre);

}
