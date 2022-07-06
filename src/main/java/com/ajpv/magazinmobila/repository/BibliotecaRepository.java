package com.ajpv.magazinmobila.repository;

import com.ajpv.magazinmobila.model.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliotecaRepository extends JpaRepository<Biblioteca, Integer> {
}
