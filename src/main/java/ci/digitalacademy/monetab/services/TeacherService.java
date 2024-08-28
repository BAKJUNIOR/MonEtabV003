package ci.digitalacademy.monetab.services;

import ci.digitalacademy.monetab.models.Student;
import ci.digitalacademy.monetab.models.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {

    Teacher save(Teacher user);
    Teacher update(Teacher user);
    Optional<Teacher> findOne(Long id);
    List<Teacher> findAll();

    void delete(Long id);
}
