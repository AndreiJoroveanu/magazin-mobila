package com.ajpv.magazinmobila.controller;

import com.ajpv.magazinmobila.model.Mobila;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {
    @GetMapping(value = "/index")
    public String index(Model model){
        return "index";
    }
}
