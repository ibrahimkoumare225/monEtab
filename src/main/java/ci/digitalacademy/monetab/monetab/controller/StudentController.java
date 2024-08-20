package ci.digitalacademy.monetab.monetab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Controller
public class StudentController {


    @GetMapping("/studentPage")
    public String homeStudent(){
        return "studentPage";
    }
    @GetMapping("ajouterStudent")
    public String addStudent(){
        return "ajouterStudent";
    }

    @GetMapping("updateStudent")
    public String updateStudent(){
        return "updateStudent";
    }

}
