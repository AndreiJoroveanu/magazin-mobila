package com.ajpv.magazinmobila.service;

import com.ajpv.magazinmobila.model.Magazin;
import com.ajpv.magazinmobila.repository.MagazinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MagazinService {
    @Autowired
    MagazinRepository magazinRepository;

    public List<Magazin> getAllMagazine() {
        return magazinRepository.findAll();
    }
}
