package com.ajpv.magazinmobila.service;

import com.ajpv.magazinmobila.model.Scaun;
import com.ajpv.magazinmobila.dto.ScaunDto;
import com.ajpv.magazinmobila.repository.ScaunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScaunService {
    @Autowired
    ScaunRepository scaunRepository;

    public List<ScaunDto> getAllScaune() {
        List<Scaun> scaunList = scaunRepository.findAll();
        return scaunList.stream()
                .map(this::mapToScaun)
                .toList();
    }

    private ScaunDto mapToScaun(Scaun scaun) {
        return ScaunDto.builder()
                .id(scaun.getId())
                .category(scaun.getCategory())
                .name(scaun.getName())
                .color(scaun.getColor())
                .material(scaun.getMaterial())
                .maxWeight(scaun.getMaxWeight())
                .price(scaun.getPrice())
                .magazinName(scaun.getMagazin().getName())
                .build();
    }

    public void saveScaun(Scaun scaun) {
        scaunRepository.save(scaun);
    }

    public Scaun getScaunById(int id) {
        return scaunRepository.findById(id).get();
    }

    public void deleteScaun(int id) {
        scaunRepository.deleteById(id);
    }
}