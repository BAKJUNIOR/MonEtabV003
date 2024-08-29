package ci.digitalacademy.monetab.services.dto;

import groovy.transform.Sealed;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class NoteFileDTO {

    private Long id;
    private String note;
    private String annee;
    private Long teacherId;  // Utilisé pour la relation avec Teacher
}
