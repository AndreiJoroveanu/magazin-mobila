package com.ajpv.magazinmobila.repository;

import com.ajpv.magazinmobila.model.Scaun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScaunRepository extends JpaRepository<Scaun, Integer> {
}
