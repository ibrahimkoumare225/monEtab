package ci.digitalacademy.monetab.monetab.services;

import ci.digitalacademy.monetab.monetab.models.Student;
import ci.digitalacademy.monetab.monetab.models.User;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student save(Student student);

    Student update(Student student);

    void delete(Long id);

    Optional<Student> findOne(Long id);

    List<Student> findAll();


}
