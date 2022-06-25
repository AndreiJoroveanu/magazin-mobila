package com.ajpv.magazinmobila.controller;

import com.ajpv.magazinmobila.model.Mobila;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {
    @GetMapping(value = "/index")
    public String index(Model model){
        List<Mobila> listaMobila = List.of(
                new Mobila(1, "Birou", "PVC N-3", "Alb",
                           "PAL", 76, 50, 96),

                new Mobila(2, "Scaun", "Kring Fit", "Negru",
                           "Plasa & Inox", 115, 46, 47),

                new Mobila(3, "Biblioteca", "Kring Ashford", "Maro/Alb",
                           "PAL", 125, 150, 28),

                new Mobila(4, "Raft", "Kring Capri", "Alb",
                           "Bambus & Metal", 110, 34, 33),

                new Mobila(5, "Comoda", "Irim Spark", "Sonoma",
                           "PAL", 91, 100, 43.5)
        );
        model.addAttribute("listaMobila", listaMobila);
        return "index";
    }
}
