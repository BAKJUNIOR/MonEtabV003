package ci.digitalacademy.monetab.services.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class AddressDTO {

    private Long id;

    private String compagny;

    private String city;

    private String street;


}
