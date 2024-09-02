package ci.digitalacademy.monetab.monetab.services.impl;

import ci.digitalacademy.monetab.monetab.models.StudentCards;
import ci.digitalacademy.monetab.monetab.repositories.StudentCardsRepositories;
import ci.digitalacademy.monetab.monetab.services.StudentCardsService;
import ci.digitalacademy.monetab.monetab.services.dto.StudentCardsDTO;
import ci.digitalacademy.monetab.monetab.services.mappeur.StudentCardsMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
@RequiredArgsConstructor
public class StudentCardsServiceImpl implements StudentCardsService {

    private final StudentCardsRepositories studentCardsRepositories;
    private final StudentCardsMapper studentCardsMapper;
    @Override
    public StudentCardsDTO save(StudentCardsDTO studentCardsDTO) {
        log.debug("Request to save : {}", studentCardsDTO);
        StudentCards studentCards = studentCardsMapper.toEntity(studentCardsDTO);
        studentCards = studentCardsRepositories.save(studentCards);
        return studentCardsMapper.toDto(studentCards);
    }

    @Override
    public StudentCardsDTO update(StudentCardsDTO studentCardsDTO) {
        log.debug("Request to upadte student{}",studentCardsDTO);
        return findOne(studentCardsDTO.getId()).map(existingStudentCardsDTO1->{
            existingStudentCardsDTO1.setExpiration_date(studentCardsDTO.getExpiration_date());
            existingStudentCardsDTO1.setReference(studentCardsDTO.getReference());
            return save(existingStudentCardsDTO1);
        }).orElseThrow(()->new IllegalArgumentException());
    }

    @Override
    public Optional<StudentCardsDTO> findOne(Long id) {
        log.debug("Request to find on studentCards",id);
        return studentCardsRepositories.findById(id).map(studentCards -> {
            return studentCardsMapper.toDto(studentCards);
        });
    }

    @Override
    public List<StudentCardsDTO> findAll() {
        log.debug("Request to find all student ");
        return studentCardsRepositories.findAll().stream().map(studentCards -> {
            return studentCardsMapper.toDto(studentCards);
        }).toList();
    }


    @Override
    public void delete(Long id) {
        log.debug("Request to delete studentCards by id{}",id);
        studentCardsRepositories.deleteById(id);
    }
}
