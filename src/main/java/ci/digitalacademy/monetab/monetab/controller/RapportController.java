package ci.digitalacademy.monetab.monetab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RapportController {

    @GetMapping("/rapport")
    public String rapport(){
        return "dynamic/rapport/rapport";
    }
}
