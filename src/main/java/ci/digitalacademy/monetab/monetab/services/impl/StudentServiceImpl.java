package ci.digitalacademy.monetab.monetab.services.impl;

import ci.digitalacademy.monetab.monetab.models.Student;
import ci.digitalacademy.monetab.monetab.models.enumerates.Gender;
import ci.digitalacademy.monetab.monetab.repositories.StudentRepository;
import ci.digitalacademy.monetab.monetab.services.StudentService;
import ci.digitalacademy.monetab.monetab.services.dto.StudentDTO;
import ci.digitalacademy.monetab.monetab.services.mappeur.StudentMapper;
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
    private  final StudentMapper studentMapper;


    @Override
    public StudentDTO save(StudentDTO studentDTO) {
        log.debug("Request to save : {}", studentDTO);
        Student student = studentMapper.toEntity(studentDTO);
        student = studentRepository.save(student);
        return studentMapper.toDto(student);
    }

    @Override
    public StudentDTO update(StudentDTO studentDTO) {
       log.debug("Request to upadte student{}",studentDTO);
        return findOne(studentDTO.getId()).map(existingStudent->{
            existingStudent.setNom(studentDTO.getNom());
            existingStudent.setPrenom(studentDTO.getPrenom());
            return save(existingStudent);
        }).orElseThrow(()->new IllegalArgumentException());
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete student by id{}",id);

        studentRepository.deleteById(id);
    }

    @Override
    public Optional<StudentDTO> findOne(Long id) {
        log.debug("Request to find on student {}",id);
        return studentRepository.findById(id).map(student -> {
            return studentMapper.toDto(student);
        });
    }
    @Override
    public List<StudentDTO> findByNomOrGenreOrMatricule(String query , String genre) {
        List<Student> students = studentRepository.findByNomIgnoreCaseOrMatriculeIgnoreCaseAndGenre(query  , query , Gender.valueOf(genre));
        return students.stream().map(student -> {
            return studentMapper.toDto(student);
        }).toList();
    }
    @Override
    public List<StudentDTO> findAll() {
        log.debug("Request to find all student ");
        return studentRepository.findAll().stream().map(student -> {
            return studentMapper.toDto(student);
        }).toList();
    }
}
