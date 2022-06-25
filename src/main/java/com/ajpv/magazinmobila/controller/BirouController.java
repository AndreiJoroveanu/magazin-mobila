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
                        "PAL", 75, 90, 55),

                new Birou(2, "Birou (Rollbox)", "Homcom", "Alb",
                        "MDF", 60, 33, 45),

                new Birou(3, "Birou", "Kring Gaming", "Alb",
                        "PAL", 91, 160, 72),

                new Birou(4, "Birou", "PVC N-3", "Alb",
                        "PAL", 76, 96, 50),

                new Birou(5, "Birou", "Homcom", "Maro",
                        "Lemn", 72, 120, 49)
        );
        model.addAttribute("listaBirou", listaBirou);
        return "birouri";
    }
}
