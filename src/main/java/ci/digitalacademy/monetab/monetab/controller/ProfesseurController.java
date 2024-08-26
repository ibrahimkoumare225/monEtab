package ci.digitalacademy.monetab.monetab.controller;

import ci.digitalacademy.monetab.monetab.models.Professeur;
import ci.digitalacademy.monetab.monetab.models.Student;
import ci.digitalacademy.monetab.monetab.repositories.ProfesseurRepository;
import ci.digitalacademy.monetab.monetab.services.ProfesseurService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProfesseurController {

private final ProfesseurService professeurService;
    @GetMapping("/homeProfesseur")
    public String homePage(Model model){
        List<Professeur> professeurs = professeurService.findAll();
        model.addAttribute("professeurs",professeurs);
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
