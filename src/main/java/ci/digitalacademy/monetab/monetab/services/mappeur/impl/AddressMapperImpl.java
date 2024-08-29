package ci.digitalacademy.monetab.monetab.services.mappeur.impl;

import ci.digitalacademy.monetab.monetab.models.Address;
import ci.digitalacademy.monetab.monetab.services.dto.AddressDTO;
import ci.digitalacademy.monetab.monetab.services.mappeur.AddressMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AddressMapperImpl implements AddressMapper {

    private final ModelMapper modelMapper;
    @Override
    public AddressDTO toDto(Address entity) {
        return modelMapper.map(entity,AddressDTO.class);
    }

    @Override
    public Address toEntity(AddressDTO dto) {
        return modelMapper.map(dto, Address.class);
    }
}
