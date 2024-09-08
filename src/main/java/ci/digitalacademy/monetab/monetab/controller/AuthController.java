package ci.digitalacademy.monetab.monetab.controller;

import ci.digitalacademy.monetab.monetab.services.AppSettingService;
import ci.digitalacademy.monetab.monetab.services.SchoolService;
import ci.digitalacademy.monetab.monetab.services.UserService;
import ci.digitalacademy.monetab.monetab.services.dto.AppSettingDTO;
import ci.digitalacademy.monetab.monetab.services.dto.SchoolDTO;
import ci.digitalacademy.monetab.monetab.services.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/index")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final UserService userService;


    private final SchoolService schoolService;


    private final AppSettingService appSettingService;

    @GetMapping
    public String showLoginPage(Model model) {
        log.debug("show login page");
        SchoolDTO schoolDTOS = schoolService.findAll().stream().findFirst().orElseThrow(null);
        model.addAttribute("school", schoolDTOS);

        return "index";

    }

    @PostMapping("save")
    public String submitForm(@ModelAttribute("user") UserDTO userDTO, BindingResult bindingResult) {
        log.debug("submit form {}", userDTO);
        String url = null;

        Optional<UserDTO> userConnexion = userService.findByPseudo(userDTO.getPseudo());
        if (userConnexion.isPresent()) {
            url =  "redirect:/home";
        }else{
            url =  "redirect:/login";
        }

        return url;

    }

}
