package com.ajpv.magazinmobila.controller;

import com.ajpv.magazinmobila.model.Scaun;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ScaunController {
    @GetMapping(value = "/scaune")
    public String index(Model model){
        List<Scaun> listaScaun = List.of(
                new Scaun(1, "Scaun", "Kring New Fit", "Negru",
                        "Plasa & Inox", 100, 117.5, 62, 47, 299.9),

                new Scaun(2, "Scaun", "Kulik System Business", "Negru",
                        "Piele ecologica", 120, 155, 50.5, 48, 3384.3),

                new Scaun(3, "Scaun", "Kring Fit", "Negru",
                        "Plasa & Inox", 100, 115, 46, 46, 329.9),

                new Scaun(4, "Scaun", "Kring Klaus", "Negru",
                        "Plasa & Inox", 150, 117, 61.5, 62.5, 399.9),

                new Scaun(5, "Scaun", "Relax Vinsetto", "Gri",
                        "Plastic", 120, 116, 53, 46, 1169.9),

                new Scaun(6, "Scaun", "Ergoplus Joy", "Negru",
                        "Stofa & Nylon", 100, 110, 50, 49, 749.9),

                new Scaun(7, "Scaun", "Kring Bokai", "Negru",
                        "Piele eco & Metal", 120, 124, 64, 69.5, 599.9),

                new Scaun(8, "Scaun", "Ergoplus Joy-H", "Negru",
                        "Stofa & Nylon", 120, 131, 51, 51, 799.9),

                new Scaun(9, "Scaun", "Timeless Tools", "Negru",
                        "Poliester & Metal", 90, 99, 48, 40, 250.0),

                new Scaun(10, "Scaun", "Kring Rome", "Bej",
                        "Metal", 100, 80, 50, 46, 249.9)
        );
        model.addAttribute("listaScaun", listaScaun);
        return "scaune";
    }
}
