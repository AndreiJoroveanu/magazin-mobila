package com.ajpv.magazinmobila.controller;

import com.ajpv.magazinmobila.model.Biblioteca;
import com.ajpv.magazinmobila.model.Scaun;
import com.ajpv.magazinmobila.repository.ScaunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ScaunController {
    @Autowired
    ScaunRepository scaunRepository;

    @GetMapping(value = "/scaune")
    public String scaun(Model model){
        List<Scaun> listaScaun = List.of(
                Scaun.builder()
                        .id(1)
                        .category("Scaun")
                        .name("Kring New Fit")
                        .color("Negru")
                        .material("Plasa & Inox")
                        .maxWeight(100)
                        .height(117.5)
                        .length(62)
                        .width(47)
                        .price(299.9)
                        .build(),

                Scaun.builder()
                        .id(2)
                        .category("Scaun")
                        .name("Kulik System Business")
                        .color("Negru")
                        .material("Piele ecologica")
                        .maxWeight(120)
                        .height(155)
                        .length(50.5)
                        .width(48)
                        .price(3384.3)
                        .build(),

                Scaun.builder()
                        .id(3)
                        .category("Scaun")
                        .name("Kring Fit")
                        .color("Negru")
                        .material("Plasa & Inox")
                        .maxWeight(100)
                        .height(115)
                        .length(46)
                        .width(46)
                        .price(329.9)
                        .build(),

                Scaun.builder()
                        .id(4)
                        .category("Scaun")
                        .name("Kring Klaus")
                        .color("Negru")
                        .material("Plasa & Inox")
                        .maxWeight(150)
                        .height(117)
                        .length(61.5)
                        .width(62.5)
                        .price(399.9)
                        .build(),

                Scaun.builder()
                        .id(5)
                        .category("Scaun")
                        .name("Relax Vinsetto")
                        .color("Gri")
                        .material("Plastic")
                        .maxWeight(120)
                        .height(116)
                        .length(53)
                        .width(46)
                        .price(1169.9)
                        .build(),

                Scaun.builder()
                        .id(6)
                        .category("Scaun")
                        .name("Ergoplus Joy")
                        .color("Negru")
                        .material("Stofa & Nylon")
                        .maxWeight(100)
                        .height(110)
                        .length(50)
                        .width(49)
                        .price(749.9)
                        .build(),

                Scaun.builder()
                        .id(7)
                        .category("Scaun")
                        .name("Kring Bokai")
                        .color("Negru")
                        .material("Piele eco & Metal")
                        .maxWeight(120)
                        .height(124)
                        .length(64)
                        .width(69.5)
                        .price(599.9)
                        .build(),

                Scaun.builder()
                        .id(8)
                        .category("Scaun")
                        .name("Ergoplus Joy-H")
                        .color("Negru")
                        .material("Stofa & Nylon")
                        .maxWeight(120)
                        .height(131)
                        .length(51)
                        .width(51)
                        .price(799.9)
                        .build(),

                Scaun.builder()
                        .id(9)
                        .category("Scaun")
                        .name("Timeless Tools")
                        .color("Negru")
                        .material("Poliester & Metal")
                        .maxWeight(90)
                        .height(99)
                        .length(48)
                        .width(40)
                        .price(250.0)
                        .build(),

                Scaun.builder()
                        .id(10)
                        .category("Scaun")
                        .name("Kring Rome")
                        .color("Bej")
                        .material("Metal")
                        .maxWeight(100)
                        .height(80)
                        .length(50)
                        .width(46)
                        .price(249.9)
                        .build()
        );
        model.addAttribute("listaScaun", listaScaun);
        return "scaune";
    }

    @GetMapping(value = "/adauga/scaun")
    public String addScaun(Model model) {
        Scaun scaun = Scaun.builder().build();
        scaun.setCategory("Scaun");
        model.addAttribute("scaun", scaun);
        return "adauga/scaun";
    }

    @PostMapping(value = "/adauga/submitScaun")
    public String submitScaun(@ModelAttribute Scaun scaun) {
        saveToDatabase(scaun);
        return "index";
    }

    private void saveToDatabase(Scaun scaun) {
        scaunRepository.save(scaun);
    }

    @GetMapping(value = "/createScaun")
    @ResponseBody
    public String createScaun(){
        Scaun scaun = Scaun.builder().build();
        scaunRepository.save(scaun);
        return "OK!";
    }

    @GetMapping(value = "/showScaun")
    @ResponseBody
    public String showScaun(){
        List<Scaun> scaunList = scaunRepository.findAll();
        for (Scaun s : scaunList){
            System.out.println(s.toString());
        }
        return "OK!";
    }
}
