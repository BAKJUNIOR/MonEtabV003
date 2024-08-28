package ci.digitalacademy.monetab.models;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "noteFile")
public class NoteFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "Note")
    private String Note;

    @Column(nullable = false, name = "annee")
    private String annee;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}