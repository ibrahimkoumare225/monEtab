package ci.digitalacademy.monetab.monetab.controller;

import ci.digitalacademy.monetab.monetab.models.User;
import ci.digitalacademy.monetab.monetab.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class UserController {
    private  final UserService userService;
    @GetMapping ("homeUser")
    public String homeUser(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
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
