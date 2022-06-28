package com.ajpv.magazinmobila.controller;

import com.ajpv.magazinmobila.model.Raft;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RaftController {
    @GetMapping(value = "/rafturi")
    public String index(Model model){
        List<Raft> listaRaft = List.of(
                new Raft(1, "Raft", "Kring Capri", "Alb/Lemn natur",
                        "Bambus & Metal", 110, 34, 33, 149.9),

                new Raft(2, "Raft (Pe roti)", "Homcom", "Argintiu",
                        "Otel inoxidabil", 85, 90, 45, 559.9),

                new Raft(3, "Raft", "Wenge", "Wenge",
                        "MDF", 30, 26.4, 10, 46.4),

                new Raft(4, "Raft (Suport router)", "SenseConnect", "Alb",
                        "Lemn (MDF) & Aliaj", 28, 36, 8.5, 188.0),

                new Raft(5, "Raft", "Homcom", "Negru",
                        "MDF", 192, 80, 25, 379.9),

                new Raft(6, "Raft", "Kring Provence", "Lemn natur",
                        "Bambus & Metal", 98, 30, 30, 149.9),

                new Raft(7, "Raft (Pe roti)", "ProCart", "Negru",
                        "Plastic", 60, 43.5, 33.5, 214.5),

                new Raft(8, "Raft", "Sonoma", "Stejar Sonoma",
                        "MDF", 10, 42, 10, 47.6),

                new Raft(9, "Raft", "STRATEGIC 5 Polite", "Gri",
                        "Otel", 180, 75, 40, 139.9),

                new Raft(10, "Raft", "STERK", "Alb",
                        "Plastic", 70, 41, 29, 36.3)
        );
        model.addAttribute("listaRaft", listaRaft);
        return "rafturi";
    }
}
