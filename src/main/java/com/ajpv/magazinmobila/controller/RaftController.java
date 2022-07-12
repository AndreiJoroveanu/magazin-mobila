package com.ajpv.magazinmobila.controller;

import com.ajpv.magazinmobila.model.Raft;
import com.ajpv.magazinmobila.dto.RaftDto;
import com.ajpv.magazinmobila.model.Magazin;
import com.ajpv.magazinmobila.service.MagazinService;
import com.ajpv.magazinmobila.service.RaftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class RaftController {
    @Autowired
    RaftService raftService;
    @Autowired
    MagazinService magazinService;

    @GetMapping(value = "/rafturi")
    public String raft(Model model){
        List<RaftDto> raftList = raftService.getAllRafturi();
        model.addAttribute("raftList", raftList);

        return "rafturi";
    }

    @GetMapping(value = "/adauga/raft")
    public String addRaft(Model model) {
        boolean exists = false;
        model.addAttribute("exists", exists);

        Raft raft = Raft.builder().category("Raft").price(BigDecimal.valueOf(0.0)).build();
        model.addAttribute("raft", raft);

        List<Magazin> magazinList = magazinService.getAllMagazine();
        model.addAttribute("magazinList", magazinList);

        return "editare/raft";
    }

    @PostMapping(value = "/editeaza/raft")
    public String editBiblioteca(@RequestParam("raftId") int id, Model model){
        boolean exists = true;
        model.addAttribute("exists", exists);

        Raft raft = raftService.getRaftById(id);
        model.addAttribute("raft", raft);

        List<Magazin> magazinList = magazinService.getAllMagazine();
        model.addAttribute("magazinList", magazinList);

        return "editare/raft";
    }

    @PostMapping(value = "/editare/submitRaft")
    public String submitRaft(@ModelAttribute Raft raft, Model model) {
        raftService.saveRaft(raft);
        return "redirect:/rafturi";
    }

    @PostMapping(value = "/editare/deleteRaft")
    public String deleteRaft(@RequestParam("raftId") int id){
        raftService.deleteRaft(id);
        return "redirect:/rafturi";
    }
}