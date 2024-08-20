package ci.digitalacademy.monetab.monetab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Controller
public class ProfesseurController {


    @GetMapping("/professorPage")
    public String homePage(){
        return "professorPage";
    }

    @GetMapping("/ajouterProfessor")
    public String addProfesseur(){
        return "ajouterProfessor";
    }
    @GetMapping("/updateProfessor")
    public String updateProfessor(){
        return "updateProfessor";
    }
}
