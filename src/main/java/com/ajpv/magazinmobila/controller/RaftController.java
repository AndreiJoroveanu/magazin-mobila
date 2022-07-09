package com.ajpv.magazinmobila.controller;

import com.ajpv.magazinmobila.model.Magazin;
import com.ajpv.magazinmobila.model.Raft;
import com.ajpv.magazinmobila.repository.MagazinRepository;
import com.ajpv.magazinmobila.repository.RaftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        Raft raft = Raft.builder().build();
        raft.setCategory("Raft");
        raft.setPrice(BigDecimal.valueOf(0.0));
        model.addAttribute("raft", raft);

        List<Magazin> magazinList = magazinRepository.findAll();
        model.addAttribute("magazinList", magazinList);

        return "adauga/raft";
    }

    @PostMapping(value = "/adauga/submitRaft")
    public String submitRaft(@ModelAttribute Raft raft) {
        saveToDatabase(raft);
        return "redirect:/rafturi";
    }

    private void saveToDatabase(Raft raft) {
        raftRepository.save(raft);
    }

    @GetMapping(value = "/createRaft")
    @ResponseBody
    public String createRaft(){
        Raft raft = Raft.builder().build();
        raftRepository.save(raft);
        return "OK!";
    }

    @GetMapping(value = "/showRaft")
    @ResponseBody
    public String showRaft(){
        List<Raft> raftList = raftRepository.findAll();
        for (Raft r : raftList){
            System.out.println(r.toString());
        }
        return "OK!";
    }
}
