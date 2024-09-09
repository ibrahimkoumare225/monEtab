package ci.digitalacademy.monetab.monetab.controller;
import ci.digitalacademy.monetab.monetab.models.StudentDataPdfExport;
import ci.digitalacademy.monetab.monetab.services.StudentService;
import ci.digitalacademy.monetab.monetab.services.dto.StudentDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    @GetMapping("/homeEleve")
    public String homeStudent(Model model){
        List<StudentDTO> students = studentService.findAll();
        model.addAttribute("students",students);
        return "dynamic/eleves/homeEleve";
    }
    @PostMapping("/homeEleve")
    public String saveStudent(StudentDTO student){
        studentService.save(student);
        return "redirect:/homeEleve";
    }
    @GetMapping("/search")
    public String searchStudents(@RequestParam String query,@RequestParam String genre, Model model)
    {
        List<StudentDTO> students = studentService.findByNomOrGenreOrMatricule(query , genre);
        model.addAttribute("students", students);
        model.addAttribute("query", query);
        model.addAttribute("genre", genre);

        return "dynamic/eleves/homeEleve";
    }
    @GetMapping("/ajouterEleve")
    public String addStudent(Model model){
        model.addAttribute("student",new StudentDTO());
        return "dynamic/eleves/ajouterEleve";
    }

    @GetMapping("/updateEleve")
    public String updateStudent(){

        return "dynamic/eleves/updateEleve";
    }

    @GetMapping("/student/{id}")
    public String showUpdateStudentForms(Model model, @PathVariable Long id){
        log.debug("Request to show update student forms");
        Optional<StudentDTO> student = studentService.findOne(id);
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

    @GetMapping("/pdf")
    public ModelAndView exportToPdf() {
        ModelAndView mav = new ModelAndView();
        mav.setView(new StudentDataPdfExport());
        //read data from DB
        List<StudentDTO> list= studentService.findAll();
        //send to pdfImpl class
        mav.addObject("list", list);
        return mav;
    }
    @GetMapping("/excelExport")
    public ModelAndView exportToExcel() {
        ModelAndView mav = new ModelAndView();
        mav.setView(new StudentDataPdfExport());
        //read data from DB
        List<StudentDTO> list= studentService.findAll();
        //send to excelImpl class
        mav.addObject("list", list);
        return mav;
    }
}
