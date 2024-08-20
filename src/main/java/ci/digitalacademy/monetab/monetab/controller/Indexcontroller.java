package ci.digitalacademy.monetab.monetab.controller;

import ci.digitalacademy.monetab.monetab.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class Indexcontroller {

    @GetMapping
    public String index(Model model){
        User user  = new User(1,"BAKAYOKO", "JUNIOR");
        User user1 = new User();
        user1 = null;
        model.addAttribute("students" , user );
        model.addAttribute("students1" , user1 );
        return "index";
    }

}
