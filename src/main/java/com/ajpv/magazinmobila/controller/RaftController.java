package com.ajpv.magazinmobila.controller;

import com.ajpv.magazinmobila.model.Birou;
import com.ajpv.magazinmobila.model.Comoda;
import com.ajpv.magazinmobila.model.Raft;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RaftController {
    @GetMapping(value = "/rafturi")
    public String raft(Model model){
        List<Raft> listaRaft = List.of(
                Raft.builder()
                        .nr(1)
                        .category("Raft")
                        .name("Kring Capri")
                        .color("Alb/Lemn natur")
                        .material("Bambus & Metal")
                        .height(110)
                        .length(34)
                        .width(33)
                        .price(149.9)
                        .build(),

                Raft.builder()
                        .nr(2)
                        .category("Raft (Pe roti)")
                        .name("Homcom")
                        .color("Argintiu")
                        .material("Otel inoxidabil")
                        .height(85)
                        .length(90)
                        .width(45)
                        .price(559.9)
                        .build(),

                Raft.builder()
                        .nr(3)
                        .category("Raft")
                        .name("Wenge")
                        .color("Wenge")
                        .material("MDF")
                        .height(30)
                        .length(26.4)
                        .width(10)
                        .price(46.4)
                        .build(),

                Raft.builder()
                        .nr(4)
                        .category("Raft (Suport router)")
                        .name("SenseConnect")
                        .color("Alb")
                        .material("Lemn (MDF) & Aliaj")
                        .height(28)
                        .length(36)
                        .width(8.5)
                        .price(188.0)
                        .build(),

                Raft.builder()
                        .nr(5)
                        .category("Raft")
                        .name("Homcom")
                        .color("Negru")
                        .material("MDF")
                        .height(192)
                        .length(80)
                        .width(25)
                        .price(379.9)
                        .build(),

                Raft.builder()
                        .nr(6)
                        .category("Raft")
                        .name("Kring Provence")
                        .color("Lemn Natur")
                        .material("Bambus & Metal")
                        .height(98)
                        .length(30)
                        .width(30)
                        .price(149.9)
                        .build(),

                Raft.builder()
                        .nr(7)
                        .category("Raft (Pe roti)")
                        .name("ProCart")
                        .color("Negru")
                        .material("Plastic")
                        .height(60)
                        .length(43.5)
                        .width(33.5)
                        .price(214.5)
                        .build(),

                Raft.builder()
                        .nr(8)
                        .category("Raft")
                        .name("Sonoma")
                        .color("Stejar Sonoma")
                        .material("MDF")
                        .height(10)
                        .length(42)
                        .width(10)
                        .price(47.6)
                        .build(),

                Raft.builder()
                        .nr(9)
                        .category("Raft")
                        .name("STRATEGIC 5 Polite")
                        .color("Gri")
                        .material("Otel")
                        .height(180)
                        .length(75)
                        .width(40)
                        .price(139.9)
                        .build(),

                Raft.builder()
                        .nr(10)
                        .category("Raft")
                        .name("STERK")
                        .color("Alb")
                        .material("Plastic")
                        .height(70)
                        .length(41)
                        .width(29)
                        .price(36.3)
                        .build()
        );
        model.addAttribute("listaRaft", listaRaft);
        return "rafturi";
    }

    @GetMapping(value = "/adauga/raft")
    public String addRaft(Model model) {
        Raft raft = Raft.builder().build();
        raft.setCategory("Raft");
        model.addAttribute("raft", raft);
        return "adauga/raft";
    }

    @PostMapping(value = "/adauga/trimiteRaft")
    public String submitRaft(@ModelAttribute Raft raft) {
        saveToDatabase(raft);
        return "index";
    }

    private void saveToDatabase(Raft raft) {
        //TODO
    }
}
