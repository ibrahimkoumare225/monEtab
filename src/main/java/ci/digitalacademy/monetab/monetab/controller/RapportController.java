package ci.digitalacademy.monetab.monetab.controller;

import ci.digitalacademy.monetab.monetab.services.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class RapportController {

    @GetMapping("/rapport")
    public String rapport(Model model){
        return "dynamic/rapport/rapport";
    }
}
