package com.ajpv.magazinmobila.controller;

import com.ajpv.magazinmobila.model.Comoda;
import com.ajpv.magazinmobila.repository.ComodaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ComodaController {
    @Autowired
    ComodaRepository comodaRepository;

    @GetMapping(value = "/comode")
    public String comoda(Model model){
        List<Comoda> listaComoda = List.of(
                Comoda.builder()
                        .id(1)
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
                        .id(2)
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
                        .id(3)
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
                        .id(4)
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
                        .id(5)
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
                        .id(6)
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
                        .id(7)
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
                        .id(8)
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
                        .id(9)
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
                        .id(10)
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

        List<Comoda> comodaList = comodaRepository.findAll();
        model.addAttribute("comodaList", comodaList);

        return "comode";
    }

    @GetMapping(value = "/adauga/comoda")
    public String addComoda(Model model) {
        Comoda comoda = Comoda.builder().build();
        comoda.setCategory("Comoda");
        model.addAttribute("comoda", comoda);
        return "adauga/comoda";
    }

    @PostMapping(value = "/adauga/submitComoda")
    public String submitComoda(@ModelAttribute Comoda comoda) {
        saveToDatabase(comoda);
        return "index";
    }

    private void saveToDatabase(Comoda comoda) {
        comodaRepository.save(comoda);
    }

    @GetMapping(value = "/createComoda")
    @ResponseBody
    public String createComoda(){
        Comoda comoda = Comoda.builder().build();
        comodaRepository.save(comoda);
        return "OK!";
    }

    @GetMapping(value = "/showComoda")
    @ResponseBody
    public String showComoda(){
        List<Comoda> comodaList = comodaRepository.findAll();
        for (Comoda c : comodaList){
            System.out.println(c.toString());
        }
        return "OK!";
    }
}
