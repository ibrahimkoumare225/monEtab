package ci.digitalacademy.monetab.monetab.controller;

import ci.digitalacademy.monetab.monetab.models.User;
import ci.digitalacademy.monetab.monetab.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
@Slf4j
@Controller
@RequestMapping
@RequiredArgsConstructor
public class UserController {
    private  final UserService userService;
    @GetMapping ("/homeUser")
    public String homeUser(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return "dynamic/utilisateur/homeUser";
    }
    @PostMapping("/homeUser")
    public String saveUser(User user){
        user.setCreationdate(Instant.now()); // Initialisation de la date de création
        userService.save(user);
        return "redirect:/homeUser";
    }
    @GetMapping("/ajouterUser")
    public String addUser(Model model){
        model.addAttribute("user",new User());
        return "dynamic/utilisateur/ajouterUser";
    }

    @GetMapping("/updateUser")
    public String updateUser(){
        return "dynamic/utilisateur/updateUser";
    }

    @GetMapping("/user/{id}")
    public String showUpdateUserForms(Model model, @PathVariable Long id){
        log.debug("Request to show update student forms");
        Optional<User> user = userService.findOne(id);
        if (user.isPresent()){
            model.addAttribute("user" , user.get());
            return "dynamic/utilisateur/ajouterUser";
        } else {
            return "redirect:/homeUser";
        }
    }
}
