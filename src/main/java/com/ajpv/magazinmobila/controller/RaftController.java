package com.ajpv.magazinmobila.controller;

import com.ajpv.magazinmobila.model.Magazin;
import com.ajpv.magazinmobila.model.Raft;
import com.ajpv.magazinmobila.repository.MagazinRepository;
import com.ajpv.magazinmobila.repository.RaftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class RaftController {
    @Autowired
    RaftRepository raftRepository;

    @Autowired
    MagazinRepository magazinRepository;

    @GetMapping(value = "/rafturi")
    public String raft(Model model){
        List<Raft> raftList = raftRepository.findAll();
        model.addAttribute("raftList", raftList);

        return "rafturi";
    }

    @GetMapping(value = "/adauga/raft")
    public String addRaft(Model model) {
        boolean exists = false;
        model.addAttribute("exists", exists);

        Raft raft = Raft.builder().category("Raft").price(BigDecimal.valueOf(0.0)).build();
        model.addAttribute("raft", raft);

        List<Magazin> magazinList = magazinRepository.findAll();
        model.addAttribute("magazinList", magazinList);

        return "editare/raft";
    }

    @PostMapping(value = "/editeaza/raft")
    public String editBiblioteca(@RequestParam("raftId") int id, Model model){
        boolean exists = true;
        model.addAttribute("exists", exists);

        Raft raft = raftRepository.findById(id).get();
        model.addAttribute("raft", raft);

        List<Magazin> magazinList = magazinRepository.findAll();
        model.addAttribute("magazinList", magazinList);

        return "editare/raft";
    }

    @PostMapping(value = "/editare/submitRaft")
    public String submitRaft(@ModelAttribute Raft raft, Model model) {
        raftRepository.save(raft);
        return "redirect:/rafturi";
    }

    @PostMapping(value = "/editare/deleteRaft")
    public String deleteRaft(@RequestParam("raftId") int id){
        raftRepository.deleteById(id);
        return "redirect:/rafturi";
    }
}
