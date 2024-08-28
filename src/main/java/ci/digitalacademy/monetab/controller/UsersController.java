package ci.digitalacademy.monetab.controller;

import ci.digitalacademy.monetab.models.Address;
import ci.digitalacademy.monetab.models.Matiere;
import ci.digitalacademy.monetab.models.Teacher;
import ci.digitalacademy.monetab.models.User;
import ci.digitalacademy.monetab.repositories.UserRepository;
import ci.digitalacademy.monetab.services.AddressService;
import ci.digitalacademy.monetab.services.StudentService;
import ci.digitalacademy.monetab.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;
    private final AddressService addressService;
    @RequestMapping("")
    public String showUserPage(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return "user/list";
    }
    @RequestMapping("/add")
    public String showAddUserPage(Model model){
        model.addAttribute("user", new User());
        return "user/forms";
    }

    @PostMapping("/user")
    public String showSaveStudent(@Valid @ModelAttribute("user") User user , BindingResult bindingResult , Model model ){
        if(bindingResult.hasErrors()){
            return "user/forms";
        }

//        if (user.getAddress() != null) {
//            Address address = user.getAddress();
//            addressService.save(address);
//            user.setAddress(address);
//        }
        user.setCreationDate(Instant.now()); // Initialisation de la date de création
        userService.save(user);

        userService.save(user);
        return "redirect:/users";

    }

    @GetMapping("/update/{id}")
    public String showUpdateStudentPage(@PathVariable Long id, Model model){
        Optional<User> user = userService.findOne(id);
        if (user.isPresent()){
            model.addAttribute("user",user.get());
            return "user/forms";
        }else {
            return  "redirect:/users";

        }

    }

    @PostMapping("/user/update/{id}")
    public String showUpdateStudent(@PathVariable Long id, @Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "user/forms";
        }

        user.setCreationDate(Instant.now()); // Initialisation de la date de création
        userService.save(user);

        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id, Model model) {
        userService.delete(id);
        return "redirect:/users";
    }

}
