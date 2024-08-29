package ci.digitalacademy.monetab.services.mapper;

import ci.digitalacademy.monetab.models.Teacher;
import ci.digitalacademy.monetab.services.dto.TeacherDTO;

public final class TeacherMapper {

    private TeacherMapper() {
    }

    // Convertir Teacher en TeacherDTO
    public static TeacherDTO toDto(Teacher teacher) {
        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setId(teacher.getId());
        teacherDTO.setNom(teacher.getNom());
        teacherDTO.setPrenom(teacher.getPrenom());
        teacherDTO.setTelephone(teacher.getTelephone());
        teacherDTO.setGenre(teacher.getGenre());
        teacherDTO.setDateNaissance(teacher.getDateNaissance());
        teacherDTO.setVacant(teacher.getVacant());
        teacherDTO.setMatiereEnseigne(teacher.getMatiereEnseigne());

        teacherDTO.setProchainCours(teacher.getProchainCours());
        teacherDTO.setSujetProchaineReunion(teacher.getSujetProchaineReunion());

        // Conversion de Address à AddressDTO (si applicable)
//        teacherDTO.setAddress(AddressMapper.toDto(teacher.getAdress()));

        return teacherDTO;
    }

    // Convertir TeacherDTO en Teacher
    public static Teacher toEntity(TeacherDTO teacherDTO) {
        Teacher teacher = new Teacher();
        teacher.setId(teacherDTO.getId());
        teacher.setNom(teacherDTO.getNom());
        teacher.setPrenom(teacherDTO.getPrenom());
        teacher.setTelephone(teacherDTO.getTelephone());
        teacher.setGenre(teacherDTO.getGenre());
        teacher.setDateNaissance(teacherDTO.getDateNaissance());
        teacher.setVacant(teacherDTO.getVacant());
        teacher.setMatiereEnseigne(teacherDTO.getMatiereEnseigne());
        teacher.setProchainCours(teacherDTO.getProchainCours());
        teacher.setSujetProchaineReunion(teacherDTO.getSujetProchaineReunion());

        // Conversion de AddressDTO à Address (si applicable)
//        teacher.setAdress(AddressMapper.toEntity(teacherDTO.getAddress()));

        return teacher;
    }
}
