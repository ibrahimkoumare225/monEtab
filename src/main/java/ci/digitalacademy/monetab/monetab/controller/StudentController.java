package ci.digitalacademy.monetab.monetab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Controller
public class StudentController {


    @GetMapping("/homeEleve")
    public String homeStudent(){
        return "dynamic/eleves/homeEleve";
    }
    @GetMapping("/ajouterEleve")
    public String addStudent(){
        return "dynamic/eleves/ajouterEleve";
    }

    @GetMapping("/updateEleve")
    public String updateStudent(){
        return "dynamic/eleves/updateEleve";
    }

}
