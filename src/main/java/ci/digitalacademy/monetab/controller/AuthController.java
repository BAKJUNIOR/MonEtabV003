package ci.digitalacademy.monetab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping
    public String showLoginPage(){
        return "auth/login";
    }




}
