package ci.digitalacademy.monetab.services.Impl;

import ci.digitalacademy.monetab.models.Teacher;
import ci.digitalacademy.monetab.repositories.TeacherRepository;
import ci.digitalacademy.monetab.services.TeacherService;
import ci.digitalacademy.monetab.services.dto.TeacherDTO;
import ci.digitalacademy.monetab.services.mapper.TeacherMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Override
    public TeacherDTO save(TeacherDTO teacherDTO) {
        log.debug("Request to save Teacher : {}", teacherDTO);
        Teacher teacher = TeacherMapper.toEntity(teacherDTO);
        teacher = teacherRepository.save(teacher);
        return TeacherMapper.toDto(teacher);
    }

    @Override
    public TeacherDTO update(TeacherDTO teacherDTO) {
        return findOne(teacherDTO.getId())
                .map(existingTeacher -> {
                    existingTeacher.setNom(teacherDTO.getNom());
                    existingTeacher.setPrenom(teacherDTO.getPrenom());
                    existingTeacher.setTelephone(teacherDTO.getTelephone());
                    existingTeacher.setGenre(teacherDTO.getGenre());
                    existingTeacher.setVacant(teacherDTO.getVacant());
                    existingTeacher.setMatiereEnseigne(teacherDTO.getMatiereEnseigne());
                    existingTeacher.setProchainCours(teacherDTO.getProchainCours());
                    existingTeacher.setSujetProchaineReunion(teacherDTO.getSujetProchaineReunion());
                    return save(existingTeacher);
                })
                .orElseThrow(() -> new IllegalArgumentException("Teacher not found with id: " + teacherDTO.getId()));
    }

    @Override
    public Optional<TeacherDTO> findOne(Long id) {
        return teacherRepository.findById(id)
                .map(TeacherMapper::toDto);
    }

    @Override
    public List<TeacherDTO> findAll() {
        return teacherRepository.findAll().stream()
                .map(TeacherMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        teacherRepository.deleteById(id);
    }
}
