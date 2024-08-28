package ci.digitalacademy.monetab.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import jakarta.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
//@DiscriminatorValue("student")
public class Student extends Personne{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "classe  ne peut pas être nul")
    @Column( name = "classe")
    private ClasseType classeType;

    @NotNull(message = "matricule  ne peut pas être nul")
    @Column( name = "matricule")
    private String matricule;

}
