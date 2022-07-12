package com.ajpv.magazinmobila.controller;

import com.ajpv.magazinmobila.model.Scaun;
import com.ajpv.magazinmobila.dto.ScaunDto;
import com.ajpv.magazinmobila.model.Magazin;
import com.ajpv.magazinmobila.service.MagazinService;
import com.ajpv.magazinmobila.service.ScaunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class ScaunController {
    @Autowired
    ScaunService scaunService;
    @Autowired
    MagazinService magazinService;

    @GetMapping(value = "/scaune")
    public String scaun(Model model){
        List<ScaunDto> scaunList = scaunService.getAllScaune();
        model.addAttribute("scaunList", scaunList);

        return "scaune";
    }

    @GetMapping(value = "/adauga/scaun")
    public String addScaun(Model model) {
        boolean exists = false;
        model.addAttribute("exists", exists);

        Scaun scaun = Scaun.builder().category("Scaun").price(BigDecimal.valueOf(0.0)).build();
        model.addAttribute("scaun", scaun);

        List<Magazin> magazinList = magazinService.getAllMagazine();
        model.addAttribute("magazinList", magazinList);

        return "editare/scaun";
    }

    @PostMapping(value = "/editeaza/scaun")
    public String editBiblioteca(@RequestParam("scaunId") int id, Model model){
        boolean exists = true;
        model.addAttribute("exists", exists);

        Scaun scaun = scaunService.getScaunById(id);
        model.addAttribute("scaun", scaun);

        List<Magazin> magazinList = magazinService.getAllMagazine();
        model.addAttribute("magazinList", magazinList);

        return "editare/scaun";
    }

    @PostMapping(value = "/editare/submitScaun")
    public String submitScaun(@ModelAttribute Scaun scaun, Model model) {
        scaunService.saveScaun(scaun);
        return "redirect:/scaune";
    }

    @PostMapping(value = "/editare/deleteScaun")
    public String deleteScaun(@RequestParam("scaunId") int id){
        scaunService.deleteScaun(id);
        return "redirect:/scaune";
    }
}