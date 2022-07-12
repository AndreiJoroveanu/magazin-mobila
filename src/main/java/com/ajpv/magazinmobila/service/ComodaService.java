package com.ajpv.magazinmobila.service;

import com.ajpv.magazinmobila.model.Comoda;
import com.ajpv.magazinmobila.dto.ComodaDto;
import com.ajpv.magazinmobila.repository.ComodaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComodaService {
    @Autowired
    ComodaRepository comodaRepository;

    public List<ComodaDto> getAllComode() {
        List<Comoda> comodaList = comodaRepository.findAll();
        return comodaList.stream()
                .map(this::mapToComoda)
                .toList();
    }

    private ComodaDto mapToComoda(Comoda comoda) {
        return ComodaDto.builder()
                .id(comoda.getId())
                .category(comoda.getCategory())
                .name(comoda.getName())
                .color(comoda.getColor())
                .material(comoda.getMaterial())
                .price(comoda.getPrice())
                .magazinName(comoda.getMagazin().getName())
                .build();
    }

    public void saveComoda(Comoda comoda) {
        comodaRepository.save(comoda);
    }

    public Comoda getComodaById(int id) {
        return comodaRepository.findById(id).get();
    }

    public void deleteComoda(int id) {
        comodaRepository.deleteById(id);
    }
}