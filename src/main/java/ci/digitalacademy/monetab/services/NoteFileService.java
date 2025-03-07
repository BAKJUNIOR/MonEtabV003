package ci.digitalacademy.monetab.services;

import ci.digitalacademy.monetab.models.NoteFile;
import ci.digitalacademy.monetab.models.Student;

import java.util.List;
import java.util.Optional;

public interface NoteFileService {

    NoteFile save(NoteFile noteFile);
    NoteFile update(NoteFile noteFile);
    Optional<NoteFile> findOne(Long id);
    List<NoteFile> findAll();

    void delete(Long id);
}
