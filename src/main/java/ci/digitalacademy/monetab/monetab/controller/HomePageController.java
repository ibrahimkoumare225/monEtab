package ci.digitalacademy.monetab.monetab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Controller
public class HomePageController {

    @GetMapping("/homePage")
     public String homePage(){
         return "homePage";
     }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
