package ci.digitalacademy.monetab.services.mapper;

import ci.digitalacademy.monetab.models.Address;
import ci.digitalacademy.monetab.services.dto.AddressDTO;

public final class AddressMapper {
    private AddressMapper(){}

    public static AddressDTO toDto(Address address) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(address.getId());
        addressDTO.setCompagny(address.getCompagny());
        addressDTO.setCity(address.getCity());
        addressDTO.setStreet(address.getStreet());
        return addressDTO;
    }

    public static Address toEntity(AddressDTO addressDTO) {
        Address address = new Address();
        address.setId(addressDTO.getId());
        address.setCompagny(addressDTO.getCompagny());
        address.setCity(addressDTO.getCity());
        address.setStreet(addressDTO.getStreet());
        return address;
    }


}
