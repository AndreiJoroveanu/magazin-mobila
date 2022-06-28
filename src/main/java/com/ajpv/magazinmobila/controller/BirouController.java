package com.ajpv.magazinmobila.controller;

import com.ajpv.magazinmobila.model.Birou;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BirouController {
    @GetMapping(value = "/birouri")
    public String index(Model model){
        List<Birou> listaBirou = List.of(
                new Birou(1, "Birou", "Nefmob Nove", "Sonoma",
                        "PAL", 75, 90, 55, 199.9),

                new Birou(2, "Birou (Rollbox)", "Homcom", "Alb",
                        "MDF", 60, 33, 45, 349.9),

                new Birou(3, "Birou", "Kring Gaming", "Alb",
                        "PAL", 91, 160, 72, 999.9),

                new Birou(4, "Birou", "PVC N-3", "Alb",
                        "PAL", 76, 96, 50, 283.7),

                new Birou(5, "Birou", "Homcom", "Maro",
                        "Lemn", 72, 120, 49, 509.9),

                new Birou(6, "Birou", "Adria", "Alb/Stejar",
                        "PAL (Stejar)", 76, 120, 50, 349.9),

                new Birou(7, "Birou", "Akord Furniture Factory", "Alb",
                        "PAL", 74, 80, 80, 306.9),

                new Birou(8, "Birou", "Kring Edge", "Crem/Negru",
                        "Otel & MDF", 74, 90, 45, 249.9),

                new Birou(9, "Birou", "VASAGLE", "Maro",
                        "Metal & MDF", 75, 149, 149, 469.9),

                new Birou(10, "Birou", "Mobiref", "Alb",
                        "PAL", 76, 100, 51, 148.9)
        );
        model.addAttribute("listaBirou", listaBirou);
        return "birouri";
    }
}
