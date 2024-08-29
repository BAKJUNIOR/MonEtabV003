package ci.digitalacademy.monetab.services.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString

@Getter
@Setter
public class StudentDTO extends PersonneDTO {

    private String classeType;
    private String matricule;

}
