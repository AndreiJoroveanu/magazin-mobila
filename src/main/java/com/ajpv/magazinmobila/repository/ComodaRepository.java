package com.ajpv.magazinmobila.repository;

import com.ajpv.magazinmobila.model.Comoda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComodaRepository extends JpaRepository<Comoda, Integer> {
}
