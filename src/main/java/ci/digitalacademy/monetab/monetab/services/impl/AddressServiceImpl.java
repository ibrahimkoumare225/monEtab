package ci.digitalacademy.monetab.monetab.services.impl;

import ci.digitalacademy.monetab.monetab.models.Address;
import ci.digitalacademy.monetab.monetab.repositories.AddressRepository;
import ci.digitalacademy.monetab.monetab.services.AddressService;
import ci.digitalacademy.monetab.monetab.services.dto.AddressDTO;
import ci.digitalacademy.monetab.monetab.services.mappeur.AddressMapper;
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
    public AddressDTO save(AddressDTO addressDTO) {
        log.debug("Request to save : {}", addressDTO);
        Address address = AddressMapper.toEntity(addressDTO);
        address = addressRepository.save(address);
        return AddressMapper.toDto(address);
    }

    @Override
    public AddressDTO update(AddressDTO addressDTO) {
        return findOne(addressDTO.getId()).map(existingAddress->{
            existingAddress.setCountry(addressDTO.getCountry());
            existingAddress.setCity(addressDTO.getCity());
            return save(existingAddress);
        }).orElseThrow(()->new IllegalArgumentException());
    }

    @Override
    public Optional<AddressDTO> findOne(Long id) {
        log.debug("Request All address {}",id);
        return addressRepository.findById(id).map(address -> {
            return AddressMapper.toDto(address);
        });
    }

    @Override
    public List<AddressDTO> findAll() {
        log.debug("Request on address {}");
        return addressRepository.findAll().stream().map(address -> {
            return AddressMapper.toDto(address);
        }).toList();
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete address {}",id);
        addressRepository.deleteById(id);
    }
}




