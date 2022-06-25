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
                        "Bambus & Metal", 110, 34, 33),

                new Raft(2, "Raft (Pe roti)", "Homcom", "Argintiu",
                        "Otel inoxidabil", 85, 90, 45),

                new Raft(3, "Raft", "Wenge", "Wenge",
                        "MDF", 30, 26.4, 10),

                new Raft(4, "Raft (Suport router)", "SenseConnect", "Alb",
                        "Lemn (MDF) & Aliaj", 28, 36, 8.5),

                new Raft(5, "Raft", "Homcom", "Negru",
                        "MDF", 192, 80, 25)
        );
        model.addAttribute("listaRaft", listaRaft);
        return "rafturi";
    }
}
