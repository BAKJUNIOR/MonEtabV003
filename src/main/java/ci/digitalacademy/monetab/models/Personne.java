package ci.digitalacademy.monetab.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

//@DiscriminatorColumn(name = "person_type")
@MappedSuperclass
//@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "nom ne peut pas être nul ")
    private String nom;
    @NotBlank(message = "prenom  ne peut pas être nul")
    private String prenom;

    @NotBlank(message = "telephone  ne peut pas être nul")
    private String telephone;

    @NotBlank(message = "Genre  ne peut pas être nul")
    private String genre;

    @Column(name = "date_naissance")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;

    @OneToOne
    @JoinColumn(name = "adress_id")
    private Address adress;
}
