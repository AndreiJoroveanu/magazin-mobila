package com.ajpv.magazinmobila.controller;

import com.ajpv.magazinmobila.model.Birou;
import com.ajpv.magazinmobila.model.Comoda;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ComodaController {
    @GetMapping(value = "/comode")
    public String index(Model model){
        List<Comoda> listaComoda = List.of(
                Comoda.builder()
                        .nr(1)
                        .category("Comoda (TV)")
                        .name("Irim Bella")
                        .color("Sonoma")
                        .material("PAL")
                        .height(39)
                        .length(120)
                        .width(40)
                        .price(169.9)
                        .build(),

                Comoda.builder()
                        .nr(2)
                        .category("Comoda")
                        .name("Homcom")
                        .color("Maro")
                        .material("Lemn")
                        .height(67)
                        .length(72)
                        .width(33.5)
                        .price(539.9)
                        .build(),

                Comoda.builder()
                        .nr(3)
                        .category("Comoda")
                        .name("Irim Spark")
                        .color("Sonoma")
                        .material("PAL")
                        .height(91)
                        .length(100)
                        .width(43.5)
                        .price(499.9)
                        .build(),

                Comoda.builder()
                        .nr(4)
                        .category("Comoda")
                        .name("Mirjan 24")
                        .color("Alb")
                        .material("PAL")
                        .height(77)
                        .length(120)
                        .width(30)
                        .price(479.0)
                        .build(),

                Comoda.builder()
                        .nr(5)
                        .category("Comoda")
                        .name("Model 6080")
                        .color("Mesteacan")
                        .material("PAL & Plastic")
                        .height(79)
                        .length(90)
                        .width(30)
                        .price(236.8)
                        .build(),

                Comoda.builder()
                        .nr(6)
                        .category("Comoda")
                        .name("Osko 120 OK6")
                        .color("Alb")
                        .material("PAL")
                        .height(77)
                        .length(120)
                        .width(30)
                        .price(479.0)
                        .build(),

                Comoda.builder()
                        .nr(7)
                        .category("Comoda")
                        .name("K Akord Furniture Factory")
                        .color("Alb")
                        .material("PAL")
                        .height(99)
                        .length(160)
                        .width(40)
                        .price(856.9)
                        .build(),

                Comoda.builder()
                        .nr(8)
                        .category("Comoda")
                        .name("Irim Faust")
                        .color("Nuc/Alb")
                        .material("PAL")
                        .height(41)
                        .length(40)
                        .width(35.5)
                        .price(119.9)
                        .build(),

                Comoda.builder()
                        .nr(9)
                        .category("Comoda")
                        .name("Akord Furniture Factory")
                        .color("Alb")
                        .material("PAL")
                        .height(77)
                        .length(60)
                        .width(40)
                        .price(295.9)
                        .build(),

                Comoda.builder()
                        .nr(10)
                        .category("Comoda")
                        .name("Kring Spicy")
                        .color("Multicolor")
                        .material("PAL")
                        .height(78)
                        .length(114)
                        .width(30)
                        .price(499.9)
                        .build()
        );
        model.addAttribute("listaComoda", listaComoda);
        return "comode";
    }

    @GetMapping(value = "/adauga/comoda")
    public String adaugaComoda(Model model) {
        Comoda comoda = Comoda.builder().build();
        model.addAttribute("comoda", comoda);
        return "adauga/comoda";
    }

    @PostMapping(value = "/adauga/trimiteComoda")
    public String trimiteComoda(@ModelAttribute Comoda comoda) {
        saveToDatabase(comoda);
        return "index";
    }

    private void saveToDatabase(Comoda comoda) {
        //TODO
    }
}
