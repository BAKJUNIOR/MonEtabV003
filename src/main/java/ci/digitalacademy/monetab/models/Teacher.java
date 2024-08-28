package ci.digitalacademy.monetab.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@DiscriminatorValue("teacher")
@Table(name = "teacher")
public class Teacher extends Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "vacant")
    private Boolean vacant;

    @Enumerated(EnumType.STRING)
    @Column(name = "matiereEnseigne")
    private Matiere matiereEnseigne;

    @Column(nullable = false, name = "prochainCours")
    private String prochainCours;

    @Column(nullable = false, name = "sujetProchainReunion")
    private String sujetProchaineReunion;







    @OneToMany(fetch = FetchType.EAGER, mappedBy = "teacher")
    private Set<NoteFile> noteFiles;

    @Override
    public String toString() {
        return "Teacher{" +
                "id_teacher=" + id +
                ", vacant=" + vacant +
                ", matiereEnseigne='" + matiereEnseigne + '\'' +
                ", prochainCours='" + prochainCours + '\'' +
                ", sujetProchaineReunion='" + sujetProchaineReunion + '\'' +
                ", noteFiles=" + noteFiles +
            '}';
}
}