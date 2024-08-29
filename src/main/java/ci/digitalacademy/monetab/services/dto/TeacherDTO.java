package ci.digitalacademy.monetab.services.dto;

import ci.digitalacademy.monetab.models.Matiere;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
@Getter
@Setter
public class TeacherDTO extends PersonneDTO {

    private Long id;
    private Boolean vacant;
    private Matiere matiereEnseigne;
    private String prochainCours;
    private String sujetProchaineReunion;
    private Set<Long> noteFileIds;  // Liste des IDs des NoteFile associés
}
