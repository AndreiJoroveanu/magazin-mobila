package com.ajpv.magazinmobila.repository;

import com.ajpv.magazinmobila.model.Raft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaftRepository extends JpaRepository<Raft, Integer> {
}
