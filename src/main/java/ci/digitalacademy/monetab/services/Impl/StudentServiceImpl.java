package ci.digitalacademy.monetab.services.Impl;

import ci.digitalacademy.monetab.models.ClasseType;
import ci.digitalacademy.monetab.models.Student;
import ci.digitalacademy.monetab.repositories.StudentRepository;
import ci.digitalacademy.monetab.services.StudentService;
import ci.digitalacademy.monetab.services.dto.StudentDTO;
import ci.digitalacademy.monetab.services.mapper.StudentMapper;
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
    private final StudentMapper studentMapper;

    @Override
    public StudentDTO save(StudentDTO studentDTO) {
        log.debug("Request to save Student : {}", studentDTO);
        Student student = studentMapper.toEntity(studentDTO);
        student = studentRepository.save(student);
        return studentMapper.toDto(student);
    }

    @Override
    public Optional<StudentDTO> findOne(Long id) {
        return studentRepository.findById(id)
                .map(studentMapper::toDto);
    }

    @Override
    public StudentDTO update(StudentDTO studentDTO) {
        return findOne(studentDTO.getId())
                .map(existingStudent -> {
                    existingStudent.setNom( studentDTO.getNom());
                    existingStudent.setPrenom(studentDTO.getPrenom());
                    existingStudent.setTelephone(studentDTO.getTelephone());
                    existingStudent.setGenre(studentDTO.getGenre());
                    existingStudent.setDateNaissance(studentDTO.getDateNaissance());
                    existingStudent.setClasseType(String.valueOf(ClasseType.valueOf(studentDTO.getClasseType())));
                    existingStudent.setMatricule(studentDTO.getMatricule());
                    return save(existingStudent);
                })
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + studentDTO.getId()));
    }

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream()
                .map(studentMapper::toDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
