package com.ajpv.magazinmobila.controller;

import com.ajpv.magazinmobila.model.Birou;
import com.ajpv.magazinmobila.dto.BirouDto;
import com.ajpv.magazinmobila.model.Magazin;
import com.ajpv.magazinmobila.service.MagazinService;
import com.ajpv.magazinmobila.service.BirouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class BirouController {
    @Autowired
    BirouService birouService;
    @Autowired
    MagazinService magazinService;

    @GetMapping(value = "/birouri")
    public String birou(Model model){
        List<BirouDto> birouList = birouService.getAllBirouri();
        model.addAttribute("birouList", birouList);

        return "birouri";
    }

    @GetMapping(value = "/adauga/birou")
    public String addBirou(Model model) {
        boolean exists = false;
        model.addAttribute("exists", exists);

        Birou birou = Birou.builder().category("Birou").price(BigDecimal.valueOf(0.0)).build();
        model.addAttribute("birou", birou);

        List<Magazin> magazinList = magazinService.getAllMagazine();
        model.addAttribute("magazinList", magazinList);

        return "editare/birou";
    }

    @PostMapping(value = "/editeaza/birou")
    public String editBiblioteca(@RequestParam("birouId") int id, Model model){
        boolean exists = true;
        model.addAttribute("exists", exists);

        Birou birou = birouService.getBirouById(id);
        model.addAttribute("birou", birou);

        List<Magazin> magazinList = magazinService.getAllMagazine();
        model.addAttribute("magazinList", magazinList);

        return "editare/birou";
    }

    @PostMapping(value = "/editare/submitBirou")
    public String submitBirou(@ModelAttribute Birou birou, Model model) {
        birouService.saveBirou(birou);
        return "redirect:/birouri";
    }

    @PostMapping(value = "/editare/deleteBirou")
    public String deleteBirou(@RequestParam("birouId") int id){
        birouService.deleteBirou(id);
        return "redirect:/birouri";
    }
}