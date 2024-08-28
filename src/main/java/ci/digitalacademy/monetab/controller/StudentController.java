package ci.digitalacademy.monetab.controller;

import ci.digitalacademy.monetab.models.Address;
import ci.digitalacademy.monetab.models.ClasseType;
import ci.digitalacademy.monetab.models.Student;
import ci.digitalacademy.monetab.services.AddressService;
import ci.digitalacademy.monetab.services.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    private final AddressService addressService;

    @GetMapping
    public String showStudentPage(Model model){
        List<Student> students = studentService.findAll();
        model.addAttribute("students",students);
        return "student/list";
    }
    @GetMapping("add")
    public String showAddStudentPage(Model model){
        model.addAttribute("student", new Student());
        model.addAttribute("typesClasse",  ClasseType.values());
        return "student/forms";
    }

    @PostMapping("/student")
    public String showSaveStudent(@Valid @ModelAttribute("student") Student student , BindingResult bindingResult , Model model ){
        if(bindingResult.hasErrors()){
            model.addAttribute("typesClasse", ClasseType.values());
            return "student/forms";
        }

//        if (student.getAdress() != null) {
//            Address address = student.getAdress();
//            addressService.save(address);
//            student.setAdress(address);
//        }

        studentService.save(student);
        return "redirect:/students";

    }

    @GetMapping("/update/{id}")
    public String showUpdateStudentPage(@PathVariable Long id, Model model){
        Optional<Student> student = studentService.findOne(id);
        if (student.isPresent()){
             model.addAttribute("typesClasse",  ClasseType.values());
            model.addAttribute("student",student.get());
            return "student/forms";
        }else {
           return  "redirect:/students";

        }

    }


    @PostMapping("/student/update/{id}")
    public String showUpdateStudent(@PathVariable Long id, @Valid @ModelAttribute("student") Student student, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("typesClasse",  ClasseType.values());
            return "student/froms";
        }
        studentService.save(student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id, Model model) {
        studentService.delete(id);
        return "redirect:/students";
    }


}