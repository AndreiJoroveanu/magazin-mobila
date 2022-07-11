package com.ajpv.magazinmobila.controller;

import com.ajpv.magazinmobila.model.Biblioteca;
import com.ajpv.magazinmobila.model.Magazin;
import com.ajpv.magazinmobila.repository.BibliotecaRepository;
import com.ajpv.magazinmobila.repository.MagazinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class BibliotecaController {
    @Autowired
    BibliotecaRepository bibliotecaRepository;

    @Autowired
    MagazinRepository magazinRepository;

    @GetMapping(value = "/biblioteci")
    public String biblioteca(Model model){
        List<Biblioteca> bibliotecaList = bibliotecaRepository.findAll();
        model.addAttribute("bibliotecaList", bibliotecaList);

        return "biblioteci";
    }

    @GetMapping(value = "/adauga/biblioteca")
    public String addBiblioteca(Model model) {
        boolean exists = false;
        model.addAttribute("exists", exists);

        Biblioteca biblioteca = Biblioteca.builder().category("Biblioteca").price(BigDecimal.valueOf(0.0)).build();
        model.addAttribute("biblioteca", biblioteca);

        List<Magazin> magazinList = magazinRepository.findAll();
        model.addAttribute("magazinList", magazinList);

        return "editare/biblioteca";
    }

    @PostMapping(value = "/editeaza/biblioteca")
    public String editBiblioteca(@RequestParam("bibliotecaId") int id, Model model){
        boolean exists = true;
        model.addAttribute("exists", exists);

        Biblioteca biblioteca = bibliotecaRepository.findById(id).get();
        model.addAttribute("biblioteca", biblioteca);

        List<Magazin> magazinList = magazinRepository.findAll();
        model.addAttribute("magazinList", magazinList);

        return "editare/biblioteca";
    }

    @PostMapping(value = "/editare/submitBiblioteca")
    public String submitBiblioteca(@ModelAttribute Biblioteca biblioteca, Model model) {
        bibliotecaRepository.save(biblioteca);
        return "redirect:/biblioteci";
    }

    @PostMapping(value = "/editare/deleteBiblioteca")
    public String deleteBiblioteca(@RequestParam("bibliotecaId") int id){
        bibliotecaRepository.deleteById(id);
        return "redirect:/biblioteci";
    }
}
