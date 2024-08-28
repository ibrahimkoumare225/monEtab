package ci.digitalacademy.monetab.monetab.services.mappeur;

import ci.digitalacademy.monetab.monetab.models.Address;
import ci.digitalacademy.monetab.monetab.services.dto.AddressDTO;

public final class AddressMapper {
     private  AddressMapper(){}
    public static AddressDTO toDto(Address address){
         AddressDTO addressDTO = new AddressDTO();
         addressDTO.setId(address.getId());
         addressDTO.setCity(address.getCity());
         addressDTO.setStreet(address.getStreet());
         addressDTO.setCountry(address.getCountry());
         return addressDTO;
    }
    public static Address toEntity(AddressDTO addressDTO){
         Address address = new Address();
         address.setId(addressDTO.getId());
         address.setCity(addressDTO.getCity());
         address.setStreet(addressDTO.getStreet());
         address.setCountry(addressDTO.getCountry());
         return address;
    }
}
