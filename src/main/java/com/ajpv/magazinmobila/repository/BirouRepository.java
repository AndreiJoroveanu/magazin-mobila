package com.ajpv.magazinmobila.repository;

import com.ajpv.magazinmobila.model.Birou;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BirouRepository extends JpaRepository<Birou, Integer> {
}
