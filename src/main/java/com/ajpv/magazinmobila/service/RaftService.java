package com.ajpv.magazinmobila.service;

import com.ajpv.magazinmobila.model.Raft;
import com.ajpv.magazinmobila.dto.RaftDto;
import com.ajpv.magazinmobila.repository.RaftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaftService {
    @Autowired
    RaftRepository raftRepository;

    public List<RaftDto> getAllRafturi() {
        List<Raft> raftList = raftRepository.findAll();
        return raftList.stream()
                .map(this::mapToRaft)
                .toList();
    }

    private RaftDto mapToRaft(Raft raft) {
        return RaftDto.builder()
                .id(raft.getId())
                .category(raft.getCategory())
                .name(raft.getName())
                .color(raft.getColor())
                .material(raft.getMaterial())
                .price(raft.getPrice())
                .magazinName(raft.getMagazin().getName())
                .build();
    }

    public void saveRaft(Raft raft) {
        raftRepository.save(raft);
    }

    public Raft getRaftById(int id) {
        return raftRepository.findById(id).get();
    }

    public void deleteRaft(int id) {
        raftRepository.deleteById(id);
    }
}