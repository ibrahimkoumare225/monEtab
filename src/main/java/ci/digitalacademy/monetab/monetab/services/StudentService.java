package ci.digitalacademy.monetab.monetab.services;

import ci.digitalacademy.monetab.monetab.models.Student;
import ci.digitalacademy.monetab.monetab.models.User;
import ci.digitalacademy.monetab.monetab.services.dto.StudentDTO;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    StudentDTO save(StudentDTO studentDTO);

    StudentDTO update(StudentDTO studentDTO);

    List<StudentDTO> findByNomOrGenreOrMatricule(String query , String genre);
    void delete(Long id);

    Optional<StudentDTO> findOne(Long id);

    List<StudentDTO> findAll();


}
