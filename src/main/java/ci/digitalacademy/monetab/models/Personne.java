package ci.digitalacademy.monetab.models;

import ci.digitalacademy.monetab.services.dto.AddressDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass // MappedSuperclass est approprié si vous ne voulez pas que Personne soit une entité en soi
public abstract class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "nom ne peut pas être nul ")
    private String nom;

    @NotBlank(message = "prenom ne peut pas être nul")
    private String prenom;

    @NotBlank(message = "telephone ne peut pas être nul")
    private String telephone;

    @NotBlank(message = "Genre ne peut pas être nul")
    private String genre;

    @Column(name = "date_naissance")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
}
