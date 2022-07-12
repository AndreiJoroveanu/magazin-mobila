package com.ajpv.magazinmobila.service;

import com.ajpv.magazinmobila.model.Biblioteca;
import com.ajpv.magazinmobila.dto.BibliotecaDto;
import com.ajpv.magazinmobila.repository.BibliotecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliotecaService {
    @Autowired
    BibliotecaRepository bibliotecaRepository;

    public List<BibliotecaDto> getAllBiblioteci() {
        List<Biblioteca> bibliotecaList = bibliotecaRepository.findAll();
        return bibliotecaList.stream()
                .map(this::mapToBiblioteca)
                .toList();
    }

    private BibliotecaDto mapToBiblioteca(Biblioteca biblioteca) {
        return BibliotecaDto.builder()
                .id(biblioteca.getId())
                .category(biblioteca.getCategory())
                .name(biblioteca.getName())
                .color(biblioteca.getColor())
                .material(biblioteca.getMaterial())
                .price(biblioteca.getPrice())
                .magazinName(biblioteca.getMagazin().getName())
                .build();
    }

    public void saveBiblioteca(Biblioteca biblioteca) {
        bibliotecaRepository.save(biblioteca);
    }

    public Biblioteca getBibliotecaById(int id) {
        return bibliotecaRepository.findById(id).get();
    }

    public void deleteBiblioteca(int id) {
        bibliotecaRepository.deleteById(id);
    }
}