package com.ajpv.magazinmobila.controller;

import com.ajpv.magazinmobila.model.Biblioteca;
import com.ajpv.magazinmobila.model.Magazin;
import com.ajpv.magazinmobila.repository.BibliotecaRepository;
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
        Biblioteca biblioteca = Biblioteca.builder().build();
        biblioteca.setCategory("Biblioteca");
        biblioteca.setPrice(BigDecimal.valueOf(0.0));
        model.addAttribute("biblioteca", biblioteca);

        List<Magazin> magazinList = magazinRepository.findAll();
        model.addAttribute("magazinList", magazinList);

        return "adauga/biblioteca";
    }

    @PostMapping(value = "/adauga/submitBiblioteca")
    public String submitBiblioteca(@ModelAttribute Biblioteca biblioteca) {
        saveToDatabase(biblioteca);
        return "redirect:/biblioteci";
    }

    private void saveToDatabase(Biblioteca biblioteca) {
        bibliotecaRepository.save(biblioteca);
    }

    @GetMapping(value = "/createBiblioteca")
    @ResponseBody
    public String createBiblioteca(){
        Biblioteca biblioteca = Biblioteca.builder().build();
        bibliotecaRepository.save(biblioteca);
        return "OK!";
    }

    @GetMapping(value = "/showBiblioteca")
    @ResponseBody
    public String showBiblioteca(){
        List<Biblioteca> bibliotecaList = bibliotecaRepository.findAll();
        for (Biblioteca bb : bibliotecaList){
            System.out.println(bb.toString());
        }
        return "OK!";
    }
}
