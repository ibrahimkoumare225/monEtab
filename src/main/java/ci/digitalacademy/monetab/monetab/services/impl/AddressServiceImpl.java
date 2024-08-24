package ci.digitalacademy.monetab.monetab.services.impl;

import ci.digitalacademy.monetab.monetab.models.Address;
import ci.digitalacademy.monetab.monetab.repositories.AddressRepository;
import ci.digitalacademy.monetab.monetab.services.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Slf4j
 @RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address update(Address address) {
        log.debug("Request to upadte address{}",address);
        Optional<Address> optionalProfesseur = findOne(address.getId());
        if(optionalProfesseur.isPresent()){
          Address addressToUpdate = optionalProfesseur.get();
            addressToUpdate.setCity(address.getCity());
            addressToUpdate.setCountry(address.getCountry());
            return save(addressToUpdate);
        }else{
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Optional<Address> findOne(Long id) {
        log.debug("Request All address {}",id);
        return addressRepository.findById(id);
    }

    @Override
    public List<Address> findAll() {
        log.debug("Request on address {}");
        return addressRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete address {}",id);
        addressRepository.deleteById(id);
    }
}
