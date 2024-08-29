package ci.digitalacademy.monetab.services.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ToString
@Getter
@Setter
public class PersonneDTO {
    private Long id;

    @NotBlank(message = "telephone  ne peut pas être nul")
    private String nom;
    @NotBlank(message = "prenom  ne peut pas être nul")
    private String prenom;

    @NotBlank(message = "telephone  ne peut pas être nul")
    private String telephone;

    @NotBlank(message = "Genre  ne peut pas être nul")
    private String genre;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;

    private AddressDTO address;

}

