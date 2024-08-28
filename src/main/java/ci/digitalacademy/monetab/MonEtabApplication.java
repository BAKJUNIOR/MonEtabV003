package ci.digitalacademy.monetab;


import ci.digitalacademy.monetab.models.*;
import ci.digitalacademy.monetab.services.*;
import ci.digitalacademy.monetab.services.dto.AddressDTO;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;


@SpringBootApplication
@AllArgsConstructor
public class MonEtabApplication implements CommandLineRunner {

    private UserService userService;

    private NoteFileService noteFileService;

    private StudentService studentService;

    private TeacherService teacherService;

    private AddressService addressService;


    public static void main(String[] args) {
        SpringApplication.run(MonEtabApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");


        /****************************************************************
                      Start Gestion des Students
         ****************************************************************/

        AddressDTO addressStudent1 = new AddressDTO();
        addressStudent1.setCity("Abidjan");
        addressStudent1.setCompagny("Atos");
        addressStudent1.setStreet("Rue 17");
        addressService.save(addressStudent1 );

        AddressDTO addressStudent2 = new AddressDTO();
        addressStudent2.setCity("Isia");
        addressStudent2.setCompagny("Isia compagny");
        addressStudent2.setStreet("Rue 25");
        addressService.save(addressStudent2);

//        Student student1 = new Student();
//        student1.setMatricule("AUHGF-KK");
//        student1.setClasseType(ClasseType.CINQUIEME);
//        student1.setNom("Bakayoko");
//        student1.setPrenom("Koffi");
//        student1.setGenre("masculin");
//        student1.setTelephone("0150496532");
//
//        try {
//            // Convertir la chaîne de caractères en un objet Date en utilisant le format
//            Date dateNaissance = formatter.parse("26/08/1994"); // Format DD/MM/YYYY
//
//            // Assigner la date convertie à l'attribut dateNaissance de l'objet student2
//            student1.setDateNaissance(dateNaissance);
//        } catch (ParseException e) {
//            // En cas d'erreur pendant la conversion, imprimer la trace de la pile pour déboguer
//            e.printStackTrace();
//        }
//
//        student1.setAdress( addressStudent1);
//
//
//        Student student2 = new Student();
//        student2.setMatricule("AUHGF-KK");
//        student2.setClasseType(ClasseType.PREMIERE);
//        student2.setNom("Kama");
//        student2.setPrenom("junior");
//        student2.setGenre("feminin");
//        student2.setTelephone("0758084992");
//        try {
//            Date dateNaissance = formatter.parse("26/08/1994"); // Format DD/MM/YYYY
//
//            student2.setDateNaissance(dateNaissance);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        student2.setAdress(addressStudent2);
//
//        studentService.save(student1);
//        studentService.save(student2);
//
//
//
//
//
//        /****************************************************************
//                      Start Gestion des Teachers
//        ****************************************************************/
//
//        // Création des adresses pour les enseignants
//        AddressDTO addressTeacher1 = new AddressDTO();
//        addressTeacher1.setCity("Abobo");
//        addressTeacher1.setCompagny("Ecole Polytechnique");
//        addressTeacher1.setStreet("Rue 15");
//        addressService.save(addressTeacher1);
//
//        Address addressTeacher2 = new Address();
//        addressTeacher2.setCity("Yopougon");
//        addressTeacher2.setCompagny("Lycée Classique");
//        addressTeacher2.setStreet("Rue 3");
//        addressService.save(addressTeacher2);
//
//
//        // Création des enseignants
//        Teacher teacher1 = new Teacher();
//        teacher1.setVacant(true);
//
//        teacher1.setNom("Pr Diaby");
//        teacher1.setPrenom("Diaby");
//        teacher1.setGenre("masculin");
//        teacher1.setTelephone("0150496532");
//        teacher1.setMatiereEnseigne(Matiere.INFORMATIQUE);
//        teacher1.setProchainCours("Géométrie Avancée");
//        teacher1.setSujetProchaineReunion("Réunion Pédagogique");
//        teacher1.setAdress(addressTeacher1);
//        try {
//            Date dateNaissance = formatter.parse("26/08/1994");
//            teacher1.setDateNaissance(dateNaissance);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        teacherService.save(teacher1);
//
//        Teacher teacher2 = new Teacher();
//        teacher2.setVacant(false);
//        teacher2.setNom("Dr Koffi");
//        teacher2.setPrenom("Koffi");
//        teacher2.setGenre("masculin");
//        teacher2.setTelephone("0758084992");
//        teacher1.setMatiereEnseigne(Matiere.ANGLAIS);
//        teacher2.setProchainCours("Mécanique des Fluides");
//        teacher2.setSujetProchaineReunion("Réunion Administrative");
//        teacher2.setAdress(addressTeacher2);
//        try {
//            Date dateNaissance = formatter.parse("26/08/1994");
//            teacher2.setDateNaissance(dateNaissance);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        teacherService.save(teacher2);
//
//
//
//
//        /****************************************************************
//                Start Gestion des utilisateurs
//         ****************************************************************/
//
//      // Création des adresses pour les utilisateurs
//        Address addressUser1 = new Address();
//        addressUser1.setCity("Koumassi");
//        addressUser1.setCompagny("Université de Bingerville");
//        addressUser1.setStreet("Rue 8");
//        addressService.save(addressUser1);
//
//        Address addressUser2 = new Address();
//        addressUser2.setCity("Treichville");
//        addressUser2.setCompagny("Centre de Formation");
//        addressUser2.setStreet("Rue 21");
//        addressService.save(addressUser2);
//
//
//        // Création de l'utilisateur
//        User user1 = new User();
//        user1.setPseudo("admin");
//        user1.setPassword("password123");
//        user1.setCreationDate(Instant.now());
//        user1.setAddress(addressUser1);
//        userService.save(user1);
//
//
//        User user2 = new User();
//        user2.setPseudo("user2");
//        user2.setPassword("password456");
//        user2.setCreationDate(Instant.now());
//        user2.setAddress(addressUser2);
//        userService.save(user2);
//



    }
}
