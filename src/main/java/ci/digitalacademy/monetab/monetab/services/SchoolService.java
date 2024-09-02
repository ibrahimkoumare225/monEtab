package ci.digitalacademy.monetab.monetab.services;

import ci.digitalacademy.monetab.monetab.services.dto.AppSettingDTO;
import ci.digitalacademy.monetab.monetab.services.dto.SchoolDTO;

import java.util.List;
import java.util.Optional;

public interface SchoolService {

    SchoolDTO initSchool(SchoolDTO schoolDTO);

    SchoolDTO existingSchool();
    SchoolDTO update(SchoolDTO schoolDTO);
    SchoolDTO save(SchoolDTO schoolDTO);

    Optional<SchoolDTO> findOne(Long id);

    List<SchoolDTO> findAll();
    void delete(Long id);
}
