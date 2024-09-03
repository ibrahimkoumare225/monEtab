package ci.digitalacademy.monetab.monetab.controller;

import ci.digitalacademy.monetab.monetab.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GobalControllerConfig {

    @Autowired
    private SchoolService schoolService;

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("school",  schoolService.findAll().stream().findFirst().orElse(null));
    }
}
