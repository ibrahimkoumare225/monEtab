package ci.digitalacademy.monetab.monetab.services;

import ci.digitalacademy.monetab.monetab.models.Address;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface AddressService {

    Address save(Address address);
    Address update(Address address);

    Optional<Address> findOne(Long id);

    List<Address> findAll();
    void delete(Long id);
}
