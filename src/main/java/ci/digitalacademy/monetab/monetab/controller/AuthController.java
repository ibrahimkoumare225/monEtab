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
@RequestMapping("login")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    @Autowired
    private final UserService userService;

    @Autowired
    private final SchoolService schoolService;

    @Autowired
    private final AppSettingService appSettingService;

    @GetMapping
    public String showLoginPage(Model model) {
        log.debug("show login page");

        List<SchoolDTO> schools = schoolService.findAll();
        List<AppSettingDTO> appSettings = appSettingService.findAll();

        if(schools.isEmpty() && appSettings.isEmpty()) {
            return "redirect:/appService";
        }else if(schools.isEmpty()) {
            return "redirect:/school";
        }else {
            SchoolDTO school = schools.get(0);
            model.addAttribute("user", new UserDTO());
            model.addAttribute("school", school);
            return "index";
        }
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
