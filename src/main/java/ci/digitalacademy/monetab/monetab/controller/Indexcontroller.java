package ci.digitalacademy.monetab.monetab.controller;

import ci.digitalacademy.monetab.monetab.models.User;
import ci.digitalacademy.monetab.monetab.services.AppSettingService;
import ci.digitalacademy.monetab.monetab.services.SchoolService;
import ci.digitalacademy.monetab.monetab.services.dto.AppSettingDTO;
import ci.digitalacademy.monetab.monetab.services.dto.SchoolDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class Indexcontroller {

    private final SchoolService schoolService;
    private final AppSettingService appSettingService;
    @GetMapping
    public String index(){
        List<SchoolDTO> schools = schoolService.findAll();
        List<AppSettingDTO> appSetting = appSettingService.findAll();

        if(appSetting.isEmpty()) {
            return "redirect:/settings";
        }else if(schools.isEmpty()) {
            return "redirect:/schools";
        }else{
            return "redirect:/login";
        }


    }
    @GetMapping("/sidebar")
    public String sidebar() {
        return "sidebar";
    }




}
