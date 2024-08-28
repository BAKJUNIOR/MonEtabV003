package ci.digitalacademy.monetab.services.Impl;

import ci.digitalacademy.monetab.models.NoteFile;
import ci.digitalacademy.monetab.repositories.NoteFileRepository;
import ci.digitalacademy.monetab.services.NoteFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteFileServiceImpl implements NoteFileService {

    private final NoteFileRepository noteFileRepository;

    @Override
    public NoteFile save(NoteFile noteFile) {
        return noteFileRepository.save(noteFile);
    }

    @Override
    public NoteFile update(NoteFile noteFile) {
        Optional<NoteFile> optionalNoteFile = findOne(noteFile.getId());
        if (optionalNoteFile.isPresent()){
            NoteFile noteFileToUpdate = optionalNoteFile.get();
            noteFileToUpdate.setNote(noteFile.getNote());
            noteFileToUpdate.setAnnee(noteFile.getAnnee());
            return save(noteFileToUpdate);
        }else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Optional<NoteFile> findOne(Long id) {
        return noteFileRepository.findById(id);
    }

    @Override
    public List<NoteFile> findAll() {
        return noteFileRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        noteFileRepository.deleteById(id);
    }
}
