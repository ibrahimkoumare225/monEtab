package ci.digitalacademy.monetab.monetab.controller;

import ci.digitalacademy.monetab.monetab.services.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class HomePageController {
    private final SchoolService schoolService;
    @GetMapping("/home")
     public String home(Model model){
        model.addAttribute("school",schoolService.findAll().get(0));
        return "layouts/home";
     }


    }
