package com.ajpv.magazinmobila.controller;

import com.ajpv.magazinmobila.model.Magazin;
import com.ajpv.magazinmobila.model.Scaun;
import com.ajpv.magazinmobila.repository.MagazinRepository;
import com.ajpv.magazinmobila.repository.ScaunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class ScaunController {
    @Autowired
    ScaunRepository scaunRepository;

    @Autowired
    MagazinRepository magazinRepository;
    @GetMapping(value = "/scaune")
    public String scaun(Model model){
        List<Scaun> scaunList = scaunRepository.findAll();
        model.addAttribute("scaunList", scaunList);

        return "scaune";
    }

    @GetMapping(value = "/adauga/scaun")
    public String addScaun(Model model) {
        Scaun scaun = Scaun.builder().build();
        scaun.setCategory("Scaun");
        scaun.setPrice(BigDecimal.valueOf(0.0));
        model.addAttribute("scaun", scaun);

        List<Magazin> magazinList = magazinRepository.findAll();
        model.addAttribute("magazinList", magazinList);

        return "adauga/scaun";
    }

    @PostMapping(value = "/adauga/submitScaun")
    public String submitScaun(@ModelAttribute Scaun scaun) {
        saveToDatabase(scaun);
        return "redirect:/scaune";
    }

    private void saveToDatabase(Scaun scaun) {
        scaunRepository.save(scaun);
    }

    @GetMapping(value = "/createScaun")
    @ResponseBody
    public String createScaun(){
        Scaun scaun = Scaun.builder().build();
        scaunRepository.save(scaun);
        return "OK!";
    }

    @GetMapping(value = "/showScaun")
    @ResponseBody
    public String showScaun(){
        List<Scaun> scaunList = scaunRepository.findAll();
        for (Scaun s : scaunList){
            System.out.println(s.toString());
        }
        return "OK!";
    }
}
