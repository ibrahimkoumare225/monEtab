package ci.digitalacademy.monetab.monetab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Controller
public class ProfesseurController {


    @GetMapping("/homeProfesseur")
    public String homePage(){
        return "dynamic/professeur/homeProfesseur";
    }

    @GetMapping("/ajouterProfesseur")
    public String addProfesseur(){
        return "dynamic/professeur/ajouterProfesseur";
    }
    @GetMapping("/updateProfesseur")
    public String updateProfessor(){
        return "dynamic/professeur/updateProfesseur";
    }
}
