package ci.digitalacademy.monetab.services.dto;

import ci.digitalacademy.monetab.models.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {

    private Long id;

    private String compagny;

    private String city;

    private String street;


}
