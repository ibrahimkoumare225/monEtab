package ci.digitalacademy.monetab.monetab.controller;

import ci.digitalacademy.monetab.monetab.models.Student;
import ci.digitalacademy.monetab.monetab.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping
@Controller
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/homeEleve")
    public String homeStudent(Model model){
        List<Student> students = studentService.findAll();
        model.addAttribute("students",students);
        return "dynamic/eleves/homeEleve";
    }
    @PostMapping("/homeEleve")
    public String saveStudent(Student student){
        studentService.save(student);
        return "redirect:/homeEleve";
    }
    @GetMapping("/ajouterEleve")
    public String addStudent(Model model){
        model.addAttribute("student",new Student());
        return "dynamic/eleves/ajouterEleve";
    }

    @GetMapping("/updateEleve")
    public String updateStudent(){

        return "dynamic/eleves/updateEleve";
    }

}
