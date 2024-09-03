package ci.digitalacademy.monetab.monetab.controller;

import ci.digitalacademy.monetab.monetab.services.AppService;
import ci.digitalacademy.monetab.monetab.services.dto.AppSettingDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/settings")
@Slf4j
@RequiredArgsConstructor
public class AppSettingController {

    private final AppService appService;

    @GetMapping
    public String showSettingPage(Model model){
        model.addAttribute("setting" , new AppSettingDTO());
        return "appService";
    }

    @PostMapping
    public String saveSettingApp(AppSettingDTO appSettingDTO) {
        appService.initApp(appSettingDTO);
        return "redirect:/school";
    }
}
