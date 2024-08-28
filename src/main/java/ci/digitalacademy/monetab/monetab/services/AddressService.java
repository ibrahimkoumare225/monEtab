package ci.digitalacademy.monetab.monetab.services;

import ci.digitalacademy.monetab.monetab.services.dto.AddressDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface AddressService {

    AddressDTO save(AddressDTO addressDTO);
    AddressDTO update(AddressDTO addressDTO);

    Optional<AddressDTO> findOne(Long id);

    List<AddressDTO> findAll();
    void delete(Long id);
}
