package ci.digitalacademy.monetab.monetab.services.impl;

import ci.digitalacademy.monetab.monetab.models.Student;
import ci.digitalacademy.monetab.monetab.models.User;
import ci.digitalacademy.monetab.monetab.repositories.StudentRepository;
import ci.digitalacademy.monetab.monetab.services.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;


    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student update(Student student) {
       log.debug("Request to upadte student{}",student);

        Optional<Student> optionalUser = findOne(student.getId());
        if(optionalUser.isPresent()){
            Student studentToUpdate = optionalUser.get();
            studentToUpdate.setClasse(student.getClasse());
            studentToUpdate.setMatricule(student.getMatricule());
            return save(studentToUpdate);
        }else{
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete student by id{}",id);

        studentRepository.deleteById(id);
    }

    @Override
    public Optional<Student> findOne(Long id) {
        log.debug("Request to find on student {}",id);
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> findAll() {
        log.debug("Request to find all student ");
        return studentRepository.findAll();
    }
}
