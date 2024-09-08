package ci.digitalacademy.monetab.monetab.controller;

import ci.digitalacademy.monetab.monetab.models.Student;
import ci.digitalacademy.monetab.monetab.services.StudentService;
import ci.digitalacademy.monetab.monetab.services.dto.StudentDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
//
//    @GetMapping("/download-pdf")
//    public ResponseEntity<byte[]> downloadPdf(HttpServletResponse response) throws DocumentException, IOException {
//        // Récupération de la liste des étudiants
//        List<StudentDTO> students = studentService.findAll();
//
//        // Création du document PDF
//        Document document = new Document();
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        PdfWriter.getInstance(document, out);
//        document.open();
//
//        // Ajout de titre
//        Font fontTitle = new Font(Font.HELVETICA, 18, Font.BOLD);
//        document.add(new Phrase("Liste des étudiants", fontTitle));
//        document.add(new Phrase("\n\n"));
//
//        // Création d'une table pour les étudiants
//        Table table = new Table(3);  // 3 colonnes : ID, Nom, Email
//        table.setWidth(100);
//        table.setPadding(3);
//        table.addCell("ID");
//        table.addCell("Nom");
//        table.addCell("Email");
//
//        // Remplissage de la table avec les données des étudiants
//        for (StudentDTO student : students) {
//            table.addCell(String.valueOf(student.getId()));
//            table.addCell(student.getName());
//            table.addCell(student.getEmail());
//        }
//
//        document.add(table);
//        document.close();
//
//        // Préparer la réponse HTTP avec le fichier PDF
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_PDF);
//        headers.setContentDispositionFormData("attachment", "students.pdf");
//
//        return ResponseEntity.ok()
//                .headers(headers)
//                .body(out.toByteArray());
//    }
}
