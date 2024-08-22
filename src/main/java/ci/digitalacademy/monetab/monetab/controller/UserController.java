package ci.digitalacademy.monetab.monetab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class UserController {

    @GetMapping ("homeUser")
    public String homeUser(){
        return "dynamic/utilisateur/homeUser";
    }

    @GetMapping("/ajouterUser")
    public String addUser(){
        return "dynamic/utilisateur/ajouterUser";
    }

    @GetMapping("/updateUser")
    public String updateUser(){
        return "dynamic/utilisateur/updateUser";
    }
}
