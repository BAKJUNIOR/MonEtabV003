package ci.digitalacademy.monetab.controller;

import ci.digitalacademy.monetab.models.*;
import ci.digitalacademy.monetab.services.AddressService;
import ci.digitalacademy.monetab.services.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;
    private final AddressService addressService;
    @RequestMapping
    public String showTeacherPage(Model model ) {
        List<Teacher> teachers = teacherService.findAll();
        model.addAttribute("teachers",teachers);
        return "teacher/list";
    }
    @RequestMapping("add")
    public String showAddStudentPage(Model model) {
        model.addAttribute("teacher", new Teacher());
        model.addAttribute("matiere", Matiere.values());
        return "teacher/forms";
    }

    @PostMapping("/teacher")
    public String showSaveStudent(@Valid @ModelAttribute("teacher") Teacher teacher , BindingResult bindingResult , Model model ){
        if(bindingResult.hasErrors()){
            model.addAttribute("matiere", Matiere.values());
            return "teacher/forms";
        }
//
//        if (teacher.getAdress() != null) {
//            Address address = teacher.getAdress();
//            addressService.save(address);
//            teacher.setAdress(address);
//        }

        teacherService.save(teacher);
        return "redirect:/teachers";

    }

    @GetMapping("/update/{id}")
    public String showUpdateStudentPage(@PathVariable Long id, Model model){
        Optional<Teacher> teacher = teacherService.findOne(id);
        if (teacher.isPresent()){
            model.addAttribute("matiere",  Matiere.values());
            model.addAttribute("teacher",teacher.get());
            return "teacher/forms";
        }else {
            return  "redirect:/teachers";

        }

    }


    @PostMapping("/teacher/update/{id}")
    public String showUpdateStudent(@PathVariable Long id, @Valid @ModelAttribute("teacher") Teacher teacher, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("matiere",  Matiere.values());
            return "teacher/forms";
        }
        teacherService.save(teacher);
        return "redirect:/students";
    }


    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id, Model model) {
        teacherService.delete(id);
        return "redirect:/teachers";
    }


}
