package ci.digitalacademy.monetab.controller;

import ci.digitalacademy.monetab.models.Address;
import ci.digitalacademy.monetab.models.Matiere;
import ci.digitalacademy.monetab.services.AddressService;
import ci.digitalacademy.monetab.services.TeacherService;
import ci.digitalacademy.monetab.services.dto.AddressDTO;
import ci.digitalacademy.monetab.services.dto.TeacherDTO;
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
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;
    private final AddressService addressService;

    @GetMapping
    public String showTeacherPage(Model model) {
        List<TeacherDTO> teachers = teacherService.findAll();
        model.addAttribute("teachers", teachers);
        return "teacher/list";
    }

    @GetMapping("add")
    public String showAddTeacherPage(Model model) {
        model.addAttribute("teacher", new TeacherDTO());
        model.addAttribute("matiere", Matiere.values());
        return "teacher/forms";
    }

    @PostMapping("/teacher")
    public String saveTeacher(@Valid @ModelAttribute("teacher") TeacherDTO teacherDTO, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("matieres", Matiere.values());
            return "teacher/forms";
        }

        // Gérer l'adresse
        if (teacherDTO.getAddress() != null) {
            Address address = AddressMapper.toEntity(teacherDTO.getAddress());
            AddressDTO savedAddressDTO = addressService.save(AddressMapper.toDto(address));
            teacherDTO.setAddress(savedAddressDTO);
        }

        teacherService.save(teacherDTO);
        redirectAttributes.addFlashAttribute("successMessage", "L'enseignant a été enregistré avec succès !");
        return "redirect:/teachers";
    }

    @GetMapping("/update/{id}")
    public String showUpdateTeacherPage(@PathVariable Long id, Model model) {
        Optional<TeacherDTO> teacherDTO = teacherService.findOne(id);
        if (teacherDTO.isPresent()) {
            model.addAttribute("teacher", teacherDTO.get());
            model.addAttribute("matieres", Matiere.values());
            return "teacher/forms";
        } else {
            return "redirect:/teachers";
        }
    }

    @PostMapping("/teacher/update/{id}")
    public String updateTeacher(@PathVariable Long id, @Valid @ModelAttribute("teacher") TeacherDTO teacherDTO, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("matieres", Matiere.values());
            return "teacher/forms";
        }

        teacherService.update(teacherDTO);
        redirectAttributes.addFlashAttribute("successMessage", "L'enseignant a été mis à jour avec succès !");
        return "redirect:/teachers";
    }

    @GetMapping("/delete/{id}")
    public String deleteTeacher(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        teacherService.delete(id);
        redirectAttributes.addFlashAttribute("successMessage", "L'enseignant a été supprimé avec succès !");
        return "redirect:/teachers";
    }
}
