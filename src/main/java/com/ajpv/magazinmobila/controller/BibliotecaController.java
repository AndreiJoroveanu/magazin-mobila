package com.ajpv.magazinmobila.controller;

import com.ajpv.magazinmobila.model.Biblioteca;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BibliotecaController {
    @GetMapping(value = "/biblioteci")
    public String index(Model model){
        List<Biblioteca> listaBiblioteca = List.of(
                new Biblioteca(1, "Biblioteca", "Kring Marseille", "Lemn natur",
                        "Lemn (bambus)", 120, 57, 32, 249.9),

                new Biblioteca(2, "Biblioteca", "Homcom", "Maro/Negru",
                        "Metal & PAL", 182, 100, 30, 699.9),

                new Biblioteca(3, "Biblioteca", "Irim Hristo", "Maro",
                        "PAL", 145.5, 158.5, 29, 499.9),

                new Biblioteca(4, "Biblioteca", "Kring Ashford", "Maro/Alb",
                        "PAL", 150, 125, 28, 399.9),

                new Biblioteca(5, "Biblioteca (Raft carti)", "MO6070", "Alb",
                        "PAL", 133, 40, 20, 199.8)
        );
        model.addAttribute("listaBiblioteca", listaBiblioteca);
        return "biblioteci";
    }
}
