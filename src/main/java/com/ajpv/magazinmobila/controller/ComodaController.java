package com.ajpv.magazinmobila.controller;

import com.ajpv.magazinmobila.model.Comoda;
import com.ajpv.magazinmobila.model.Magazin;
import com.ajpv.magazinmobila.repository.ComodaRepository;
import com.ajpv.magazinmobila.repository.MagazinRepository;
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
public class ComodaController {
    @Autowired
    ComodaRepository comodaRepository;

    @Autowired
    MagazinRepository magazinRepository;
    @GetMapping(value = "/comode")
    public String comoda(Model model){
        List<Comoda> comodaList = comodaRepository.findAll();
        model.addAttribute("comodaList", comodaList);

        return "comode";
    }

    @GetMapping(value = "/adauga/comoda")
    public String addComoda(Model model) {
        Comoda comoda = Comoda.builder().build();
        comoda.setCategory("Comoda");
        comoda.setPrice(BigDecimal.valueOf(0.0));
        model.addAttribute("comoda", comoda);

        List<Magazin> magazinList = magazinRepository.findAll();
        model.addAttribute("magazinList", magazinList);

        return "adauga/comoda";
    }

    @PostMapping(value = "/adauga/submitComoda")
    public String submitComoda(@ModelAttribute Comoda comoda) {
        saveToDatabase(comoda);
        return "redirect:/comode";
    }

    private void saveToDatabase(Comoda comoda) {
        comodaRepository.save(comoda);
    }

    @GetMapping(value = "/createComoda")
    @ResponseBody
    public String createComoda(){
        Comoda comoda = Comoda.builder().build();
        comodaRepository.save(comoda);
        return "OK!";
    }

    @GetMapping(value = "/showComoda")
    @ResponseBody
    public String showComoda(){
        List<Comoda> comodaList = comodaRepository.findAll();
        for (Comoda c : comodaList){
            System.out.println(c.toString());
        }
        return "OK!";
    }
}
