package com.ajpv.magazinmobila.repository;

import com.ajpv.magazinmobila.model.Magazin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MagazinRepository extends JpaRepository<Magazin, Integer> {
}
