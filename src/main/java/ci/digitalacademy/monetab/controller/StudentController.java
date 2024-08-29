package ci.digitalacademy.monetab.controller;

import ci.digitalacademy.monetab.models.Address;
import ci.digitalacademy.monetab.models.ClasseType;
import ci.digitalacademy.monetab.services.dto.AddressDTO;
import ci.digitalacademy.monetab.services.dto.StudentDTO;
import ci.digitalacademy.monetab.services.StudentService;
import ci.digitalacademy.monetab.services.AddressService;
import ci.digitalacademy.monetab.services.mapper.AddressMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;


    @GetMapping
    public String showStudentPage(Model model) {
        List<StudentDTO> students = studentService.findAll();
        model.addAttribute("students", students);
        return "student/list";
    }

    @GetMapping("add")
    public String showAddStudentPage(Model model) {
        model.addAttribute("student", new StudentDTO());
        model.addAttribute("typesClasse", ClasseType.values());
        return "student/forms";
    }

    @PostMapping("/student")
    public String showSaveStudent(@Valid StudentDTO studentDTO, BindingResult bindingResult, Model model , RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("typesClasse", ClasseType.values());
            return "student/forms";
        }
        studentService.save(studentDTO);

        redirectAttributes.addFlashAttribute("successMessage", "L'élève a été enregistré avec succès!!");
        return "redirect:/students";
    }




    @GetMapping("/update/{id}")
    public String showUpdateStudentPage(@PathVariable Long id, Model model) {
        Optional<StudentDTO> studentDTO = studentService.findOne(id);
        if (studentDTO.isPresent()) {
            model.addAttribute("student", studentDTO.get());
            model.addAttribute("typesClasse", ClasseType.values());
            return "student/forms";
        } else {
            return "redirect:/students";
        }
    }



    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        studentService.delete(id);
        redirectAttributes.addFlashAttribute("successMessage", "L'élève a été supprimé avec succès !");
        return "redirect:/students";
    }
}
