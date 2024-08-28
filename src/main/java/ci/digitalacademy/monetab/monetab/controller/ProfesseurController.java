package ci.digitalacademy.monetab.monetab.controller;

import ci.digitalacademy.monetab.monetab.models.Professeur;
import ci.digitalacademy.monetab.monetab.services.ProfesseurService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor

public class ProfesseurController {

    private final ProfesseurService professeurService;

    @GetMapping("/homeProfesseur")
    public String homePage(Model model) {
        List<Professeur> professeurs = professeurService.findAll();
        model.addAttribute("professeurs", professeurs);
        return "dynamic/professeur/homeProfesseur";
    }

    @PostMapping("/homeProfesseur")
    public String saveProfesseur(Professeur teacher) {
        professeurService.save(teacher);
        return "redirect:/homeProfesseur";
    }

    @GetMapping("/ajouterProfesseur")
    public String showAddTeacherForms(Model model) {
        model.addAttribute("teacher", new Professeur());
        return "dynamic/professeur/ajouterProfesseur";
    }

    @GetMapping("/updateProfesseur")
    public String updateProfessor() {
        return "dynamic/professeur/updateProfesseur";
    }

    @GetMapping("/{id}")
    public String showUpdateTeacherForms(Model model, @PathVariable Long id) {
        log.debug("Request to show update teacher forms");
        Optional<Professeur> teacher = professeurService.findOne(id);
        if (teacher.isPresent()) {
            model.addAttribute("teacher", teacher.get());
            return "dynamic/professeur/ajouterProfesseur";
        } else {
            return "redirect:/homeProfesseur";
        }
    }

    @PostMapping("/deleteProfesseur/{id}")
    public String deleteProfesseur(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        log.info("Deleting professeur with id: " + id);
        professeurService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Professeur deleted successfully!");
        return "redirect:/homeProfesseur";
    }
}