package com.ajpv.magazinmobila.service;

import com.ajpv.magazinmobila.model.Birou;
import com.ajpv.magazinmobila.dto.BirouDto;
import com.ajpv.magazinmobila.repository.BirouRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BirouService {
    @Autowired
    BirouRepository birouRepository;

    public List<BirouDto> getAllBirouri() {
        List<Birou> birouList = birouRepository.findAll();
        return birouList.stream()
                .map(this::mapToBirou)
                .toList();
    }

    private BirouDto mapToBirou(Birou birou) {
        return BirouDto.builder()
                .id(birou.getId())
                .category(birou.getCategory())
                .name(birou.getName())
                .color(birou.getColor())
                .material(birou.getMaterial())
                .price(birou.getPrice())
                .magazinName(birou.getMagazin().getName())
                .build();
    }

    public void saveBirou(Birou birou) {
        birouRepository.save(birou);
    }

    public Birou getBirouById(int id) {
        return birouRepository.findById(id).get();
    }

    public void deleteBirou(int id) {
        birouRepository.deleteById(id);
    }
}