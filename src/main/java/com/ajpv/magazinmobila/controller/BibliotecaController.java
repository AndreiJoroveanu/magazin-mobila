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
                        "PAL", 133, 40, 20, 199.8),

                new Biblioteca(6, "Biblioteca", "Kring Bath", "Alb/Maro",
                        "PAL", 180, 75, 25, 249.9),

                new Biblioteca(7, "Biblioteca", "Irim Clara", "Alb/Maro",
                        "PAL", 137.5, 143.5, 33, 499.9),

                new Biblioteca(8, "Biblioteca", "MO6071", "Alb",
                        "PAL & PVC", 122, 45, 22, 199.8),

                new Biblioteca(9, "Biblioteca", "Kring Barking", "Wenge",
                        "PAL & ABS", 131, 50, 25, 249.9),

                new Biblioteca(10, "Biblioteca", "Sonoma", "Sonoma",
                        "PAL", 200, 70, 32, 415.0)
        );
        model.addAttribute("listaBiblioteca", listaBiblioteca);
        return "biblioteci";
    }
}
