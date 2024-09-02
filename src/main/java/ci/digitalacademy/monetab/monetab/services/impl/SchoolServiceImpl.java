package ci.digitalacademy.monetab.monetab.services.impl;

import ci.digitalacademy.monetab.monetab.models.School;
import ci.digitalacademy.monetab.monetab.repositories.SchoolRepositories;
import ci.digitalacademy.monetab.monetab.services.SchoolService;
import ci.digitalacademy.monetab.monetab.services.dto.SchoolDTO;
import ci.digitalacademy.monetab.monetab.services.mappeur.SchoolMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepositories schoolRepositories;
    private final SchoolMapper schoolMapper;


    @Override
    public SchoolDTO initSchool(SchoolDTO schoolDTO) {
        log.debug("Request to init school {}", schoolDTO);
        SchoolDTO school = existingSchool();
        if (Objects.isNull(school)){
            return save(schoolDTO);
        }
        return school;

    }

    @Override
    public SchoolDTO existingSchool() {
        log.debug("Request to check existing school");
        List<SchoolDTO> schoolDTO = findAll();
        return schoolDTO.stream().findFirst().orElse(null);

    }

    @Override
    public SchoolDTO update(SchoolDTO schoolDTO) {
        return findOne(schoolDTO.getId()).map(existingSchool ->{
            existingSchool.setName(schoolDTO.getName());
            existingSchool.setUrl_logo(schoolDTO.getUrl_logo());
            return save(schoolDTO);
        }).orElseThrow(()-> new IllegalArgumentException());

    }

    @Override
    public SchoolDTO save(SchoolDTO schoolDTO) {

        log.debug("Request to save: {}", schoolDTO );
        School school = schoolMapper.toEntity(schoolDTO);
        school = schoolRepositories.save(school);
        return schoolMapper.toDto(school);
    }

    @Override
    public Optional<SchoolDTO> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public List<SchoolDTO> findAll() {
        return schoolRepositories.findAll().stream().map(school -> {
            return schoolMapper.toDto(school);
        }).toList();
    }

    @Override
    public void delete(Long id) {

    }
}
