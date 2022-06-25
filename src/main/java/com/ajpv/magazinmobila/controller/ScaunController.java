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
                        "Plasa & Inox", 100, 117.5, 62, 47),

                new Scaun(2, "Scaun", "Kulik System Business", "Negru",
                        "Piele ecologica", 120, 155, 50.5, 48),

                new Scaun(3, "Scaun", "Kring Fit", "Negru",
                        "Plasa & Inox", 100, 115, 46, 46),

                new Scaun(4, "Scaun", "Kring Klaus", "Negru",
                        "Plasa & Inox", 150, 117, 61.5, 62.5),

                new Scaun(5, "Scaun", "Relax Vinsetto", "Gri",
                        "Plastic", 120, 116, 53, 46)
        );
        model.addAttribute("listaScaun", listaScaun);
        return "scaune";
    }
}