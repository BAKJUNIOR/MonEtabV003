package ci.digitalacademy.monetab.services.Impl;

import ci.digitalacademy.monetab.models.Student;
import ci.digitalacademy.monetab.repositories.StudentRepository;
import ci.digitalacademy.monetab.services.StudentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student update(Student student) {
        log.debug("Requête pour mettre à jour l'étudiant {}", student);
        return findOne(student.getId())
                .map(existingStudent -> {
                    existingStudent.setClasseType(student.getClasseType());
                    existingStudent.setMatricule(student.getMatricule());
                    return save(existingStudent);
                })
                .orElseThrow(() -> new EntityNotFoundException
                        ("L'étudiant avec cet id n'a pas été retrouvé " + student.getId()));
    }

    @Override
    public Optional<Student> findOne(Long id) {
        log.debug("Requête pour trouver un étudiant {}", id);
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> findAll() {
        log.debug("Requête pour trouver tous les étudiants");
        return studentRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        log.debug("Requête pour supprimer un étudiant {}", id);
        studentRepository.deleteById(id);
    }

}
