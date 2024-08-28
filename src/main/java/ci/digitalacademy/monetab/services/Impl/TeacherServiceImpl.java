package ci.digitalacademy.monetab.services.Impl;

import ci.digitalacademy.monetab.models.Teacher;
import ci.digitalacademy.monetab.repositories.TeacherRepository;
import ci.digitalacademy.monetab.services.TeacherService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher update(Teacher teacher) {
        Optional<Teacher> optionalTeacher = findOne(teacher.getId());
        if (optionalTeacher.isPresent()){
            Teacher teacherToUpdate = optionalTeacher.get();
            teacherToUpdate.setMatiereEnseigne(teacher.getMatiereEnseigne());
            teacherToUpdate.setVacant(teacher.getVacant());
            teacherToUpdate.setProchainCours(teacher.getProchainCours());
            teacherToUpdate.setSujetProchaineReunion(teacher.getSujetProchaineReunion());
            return save(teacherToUpdate);
        }else {
            throw new IllegalArgumentException();
        }

    }

    @Override
    public Optional<Teacher> findOne(Long id) {
        log.debug("Requête pour trouver un enseignant {}", id);
        return teacherRepository.findById(id);
    }

    @Override
    public List<Teacher> findAll() {
        log.debug("Requête pour trouver tous les enseignants");
        return teacherRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        log.debug("Requête pour supprimer un enseignant {}", id);
        teacherRepository.deleteById(id);
    }
}
