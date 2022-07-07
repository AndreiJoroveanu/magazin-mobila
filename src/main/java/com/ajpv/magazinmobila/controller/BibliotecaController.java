package com.ajpv.magazinmobila.controller;

import com.ajpv.magazinmobila.model.Biblioteca;
import com.ajpv.magazinmobila.repository.BibliotecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BibliotecaController {
    @Autowired
    BibliotecaRepository bibliotecaRepository;

    @GetMapping(value = "/biblioteci")
    public String biblioteca(Model model){
        List<Biblioteca> listaBiblioteca = List.of(
                Biblioteca.builder()
                        .id(1)
                        .category("Biblioteca")
                        .name("Kring Marseille")
                        .color("Lemn natur")
                        .material("Lemn (bambus)")
                        .height(120)
                        .length(57)
                        .width(32)
                        .price(249.9)
                        .build(),

                Biblioteca.builder()
                        .id(2)
                        .category("Biblioteca")
                        .name("Homcom")
                        .color("Maro/Negru")
                        .material("Metal & PAL")
                        .height(182)
                        .length(100)
                        .width(30)
                        .price(699.9)
                        .build(),

                Biblioteca.builder()
                        .id(3)
                        .category("Biblioteca")
                        .name("Irim Hristo")
                        .color("Maro")
                        .material("PAL")
                        .height(145.5)
                        .length(158.5)
                        .width(29)
                        .price(499.9)
                        .build(),

                Biblioteca.builder()
                        .id(4)
                        .category("Biblioteca")
                        .name("Kring Ashford")
                        .color("Maro/Alb")
                        .material("PAL")
                        .height(150)
                        .length(125)
                        .width(28)
                        .price(399.9)
                        .build(),

                Biblioteca.builder()
                        .id(5)
                        .category("Biblioteca (Raft carti)")
                        .name("MO6070")
                        .color("Alb")
                        .material("PAL")
                        .height(133)
                        .length(40)
                        .width(20)
                        .price(199.8)
                        .build(),

                Biblioteca.builder()
                        .id(6)
                        .category("Biblioteca")
                        .name("Kring Bath")
                        .color("Alb/Maro")
                        .material("PAL")
                        .height(180)
                        .length(75)
                        .width(25)
                        .price(249.9)
                        .build(),

                Biblioteca.builder()
                        .id(7)
                        .category("Biblioteca")
                        .name("Irim Clara")
                        .color("Alb/Maro")
                        .material("PAL")
                        .height(137.5)
                        .length(143.5)
                        .width(33)
                        .price(499.9)
                        .build(),

                Biblioteca.builder()
                        .id(8)
                        .category("Biblioteca")
                        .name("MO6071")
                        .color("Alb")
                        .material("PAL & PVC")
                        .height(122)
                        .length(45)
                        .width(22)
                        .price(199.8)
                        .build(),

                Biblioteca.builder()
                        .id(9)
                        .category("Biblioteca")
                        .name("Kring Barking")
                        .color("Wenge")
                        .material("PAL & ABS")
                        .height(131)
                        .length(50)
                        .width(25)
                        .price(249.9)
                        .build(),

                Biblioteca.builder()
                        .id(10)
                        .category("Biblioteca")
                        .name("Sonoma")
                        .color("Sonoma")
                        .material("PAL")
                        .height(200)
                        .length(70)
                        .width(32)
                        .price(32)
                        .build()
        );
        model.addAttribute("listaBiblioteca", listaBiblioteca);

        List<Biblioteca> bibliotecaList = bibliotecaRepository.findAll();
        model.addAttribute("bibliotecaList", bibliotecaList);

        return "biblioteci";
    }

    @GetMapping(value = "/adauga/biblioteca")
    public String addBiblioteca(Model model) {
        Biblioteca biblioteca = Biblioteca.builder().build();
        biblioteca.setCategory("Biblioteca");
        model.addAttribute("biblioteca", biblioteca);
        return "adauga/biblioteca";
    }

    @PostMapping(value = "/adauga/submitBiblioteca")
    public String submitBiblioteca(@ModelAttribute Biblioteca biblioteca) {
        saveToDatabase(biblioteca);
        return "index";
    }

    private void saveToDatabase(Biblioteca biblioteca) {
        bibliotecaRepository.save(biblioteca);
    }

    @GetMapping(value = "/createBiblioteca")
    @ResponseBody
    public String createBiblioteca(){
        Biblioteca biblioteca = Biblioteca.builder().build();
        bibliotecaRepository.save(biblioteca);
        return "OK!";
    }

    @GetMapping(value = "/showBiblioteca")
    @ResponseBody
    public String showBiblioteca(){
        List<Biblioteca> bibliotecaList = bibliotecaRepository.findAll();
        for (Biblioteca bb : bibliotecaList){
            System.out.println(bb.toString());
        }
        return "OK!";
    }
}
