package ci.digitalacademy.monetab.monetab.controller;

import ci.digitalacademy.monetab.monetab.models.Student;
import ci.digitalacademy.monetab.monetab.services.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Slf4j
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

    @GetMapping("/student/{id}")
    public String showUpdateStudentForms(Model model, @PathVariable Long id){
        log.debug("Request to show update student forms");
        Optional<Student> student = studentService.findOne(id);
        if (student.isPresent()){
            model.addAttribute("student" , student.get());
            return "dynamic/eleves/ajouterEleve";
        } else {
            return "redirect:/homeEleve";
        }
    }

    @PostMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        log.info("Deleting student with id: " + id);
        studentService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Student deleted successfully!");
        return "redirect:/homeEleve";
    }

}
