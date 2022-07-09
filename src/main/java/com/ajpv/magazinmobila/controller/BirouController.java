package com.ajpv.magazinmobila.controller;

import com.ajpv.magazinmobila.model.Birou;
import com.ajpv.magazinmobila.model.Magazin;
import com.ajpv.magazinmobila.repository.BirouRepository;
import com.ajpv.magazinmobila.repository.MagazinRepository;
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
public class BirouController {
    @Autowired
    BirouRepository birouRepository;

    @Autowired
    MagazinRepository magazinRepository;

    @GetMapping(value = "/birouri")
    public String birou(Model model){
        List<Birou> birouList = birouRepository.findAll();
        model.addAttribute("birouList", birouList);

        return "birouri";
    }

    @GetMapping(value = "/adauga/birou")
    public String addBirou(Model model) {
        Birou birou = Birou.builder().build();
        birou.setCategory("Birou");
        birou.setPrice(BigDecimal.valueOf(0.0));
        model.addAttribute("birou", birou);

        List<Magazin> magazinList = magazinRepository.findAll();
        model.addAttribute("magazinList", magazinList);

        return "adauga/birou";
    }

    @PostMapping(value = "/adauga/submitBirou")
    public String submitBirou(@ModelAttribute Birou birou) {
        saveToDatabase(birou);
        return "redirect:/birouri";
    }

    private void saveToDatabase(Birou birou) {
        birouRepository.save(birou);
    }

    @GetMapping(value = "/createBirou")
    @ResponseBody
    public String createBirou(){
        Birou birou = Birou.builder().build();
        birouRepository.save(birou);
        return "OK!";
    }

    @GetMapping(value = "/showBirou")
    @ResponseBody
    public String showBirou(){
        List<Birou> birouList = birouRepository.findAll();
        for (Birou br : birouList){
            System.out.println(br.toString());
        }
        return "OK!";
    }
}
