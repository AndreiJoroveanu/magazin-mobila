package com.ajpv.magazinmobila.controller;

import com.ajpv.magazinmobila.model.Comoda;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ComodaController {
    @GetMapping(value = "/comode")
    public String index(Model model){
        List<Comoda> listaComoda = List.of(
                new Comoda(1, "Comoda (TV)", "Irim Bella", "Sonoma",
                        "PAL", 39, 120, 40, 169.9),

                new Comoda(2, "Comoda", "Homcom", "Maro",
                        "Lemn", 67, 72, 33.5, 539.9),

                new Comoda(5, "Comoda", "Irim Spark", "Sonoma",
                        "PAL", 91, 100, 43.5, 499.9),

                new Comoda(4, "Comoda", "Mirjan 24", "Alb",
                        "PAL", 77, 120, 30, 479.0),

                new Comoda(5, "Comoda", "Model 6080", "Mesteacan",
                        "PAL & Plastic", 79, 90, 30, 236.8),

                new Comoda(6, "Comoda", "Osko 120 OK6", "Alb",
                        "PAL", 77, 120, 30, 479.0),

                new Comoda(7, "Comoda", "K Akord Furniture Factory", "Alb",
                        "PAL", 99, 160, 40, 856.9),

                new Comoda(8, "Comoda", "Irim Faust", "Nuc/Alb",
                        "PAL", 41, 40, 35.5, 119.9),

                new Comoda(9, "Comoda", "Akord Furniture Factory", "Alb",
                        "PAL", 77, 60, 40, 295.9),

                new Comoda(10, "Comoda", "Kring Spicy", "Multicolor",
                        "PAL", 78, 114, 30, 499.9)
        );
        model.addAttribute("listaComoda", listaComoda);
        return "comode";
    }
}
