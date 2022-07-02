package com.ajpv.magazinmobila.controller;

import com.ajpv.magazinmobila.model.Biblioteca;
import com.ajpv.magazinmobila.model.Birou;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BirouController {
    @GetMapping(value = "/birouri")
    public String index(Model model){
        List<Birou> listaBirou = List.of(
                Birou.builder()
                        .nr(1)
                        .category("Birou")
                        .name("Nefmob Nove")
                        .color("Sonoma")
                        .material("PAL")
                        .height(75)
                        .length(90)
                        .width(55)
                        .price(199.9)
                        .build(),

                Birou.builder()
                        .nr(2)
                        .category("Birou (Rollbox)")
                        .name("Homcom")
                        .color("Alb")
                        .material("MDF")
                        .height(60)
                        .length(33)
                        .width(45)
                        .price(349.9)
                        .build(),

                Birou.builder()
                        .nr(3)
                        .category("Birou")
                        .name("Kring Gaming")
                        .color("Alb")
                        .material("PAL")
                        .height(91)
                        .length(160)
                        .width(72)
                        .price(999.9)
                        .build(),

                Birou.builder()
                        .nr(4)
                        .category("Birou")
                        .name("PVC N-3")
                        .color("Alb")
                        .material("PAL")
                        .height(76)
                        .length(96)
                        .width(50)
                        .price(283.7)
                        .build(),

                Birou.builder()
                        .nr(5)
                        .category("Birou")
                        .name("Homcom")
                        .color("Maro")
                        .material("Lemn")
                        .height(72)
                        .length(120)
                        .width(49)
                        .price(509.9)
                        .build(),

                Birou.builder()
                        .nr(6)
                        .category("Birou")
                        .name("Adria")
                        .color("Alb/Stejar")
                        .material("PAL (Stejar)")
                        .height(76)
                        .length(120)
                        .width(50)
                        .price(349.9)
                        .build(),

                Birou.builder()
                        .nr(7)
                        .category("Birou")
                        .name("Akord Furniture Factory")
                        .color("Alb")
                        .material("PAL")
                        .height(74)
                        .length(80)
                        .width(80)
                        .price(306.9)
                        .build(),

                Birou.builder()
                        .nr(8)
                        .category("Birou")
                        .name("Kring Edge")
                        .color("Crem/Negru")
                        .material("Otel & MDF")
                        .height(74)
                        .length(90)
                        .width(45)
                        .price(249.9)
                        .build(),

                Birou.builder()
                        .nr(9)
                        .category("Birou")
                        .name("VASAGLE")
                        .color("Maro")
                        .material("Metal & MDF")
                        .height(75)
                        .length(149)
                        .width(149)
                        .price(469.9)
                        .build(),

                Birou.builder()
                        .nr(10)
                        .category("Birou")
                        .name("Mobiref")
                        .color("Alb")
                        .material("PAL")
                        .height(76)
                        .length(100)
                        .width(41)
                        .price(148.9)
                        .build()
        );
        model.addAttribute("listaBirou", listaBirou);
        return "birouri";
    }

    @GetMapping(value = "/adauga/birou")
    public String adaugaBirou(Model model) {
        Birou birou = Birou.builder().build();
        model.addAttribute("birou", birou);
        return "adauga/birou";
    }

    @PostMapping(value = "/adauga/trimiteBirou")
    public String trimiteBirou(@ModelAttribute Birou birou) {
        saveToDatabase(birou);
        return "index";
    }

    private void saveToDatabase(Birou birou) {
        //TODO
    }
}
