package ci.digitalacademy.monetab.monetab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class UserController {

    @GetMapping ("userPage")
    public String homeUser(){
        return "userPage";
    }

    @GetMapping("/ajouterUser")
    public String addUser(){
        return "ajouterUser";
    }

    @GetMapping("/updateUser")
    public String updateUser(){
        return "updateUser";
    }
}
