package com.ajpv.magazinmobila.controller;

import com.ajpv.magazinmobila.model.Comoda;
import com.ajpv.magazinmobila.model.Magazin;
import com.ajpv.magazinmobila.repository.ComodaRepository;
import com.ajpv.magazinmobila.repository.MagazinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        boolean exists = false;
        model.addAttribute("exists", exists);

        Comoda comoda = Comoda.builder().category("Comoda").price(BigDecimal.valueOf(0.0)).build();
        model.addAttribute("comoda", comoda);

        List<Magazin> magazinList = magazinRepository.findAll();
        model.addAttribute("magazinList", magazinList);

        return "editare/comoda";
    }

    @PostMapping(value = "/editeaza/comoda")
    public String editBiblioteca(@RequestParam("comodaId") int id, Model model){
        boolean exists = true;
        model.addAttribute("exists", exists);

        Comoda comoda =comodaRepository.findById(id).get();
        model.addAttribute("comoda", comoda);

        List<Magazin> magazinList = magazinRepository.findAll();
        model.addAttribute("magazinList", magazinList);

        return "editare/comoda";
    }

    @PostMapping(value = "/editare/submitComoda")
    public String submitComoda(@ModelAttribute Comoda comoda, Model model) {
        comodaRepository.save(comoda);
        return "redirect:/comode";
    }

    @PostMapping(value = "/editare/deleteComoda")
    public String deleteComoda(@RequestParam("comodaId") int id){
        comodaRepository.deleteById(id);
        return "redirect:/comode";
    }
}
