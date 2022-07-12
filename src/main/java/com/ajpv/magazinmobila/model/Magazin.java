package com.ajpv.magazinmobila.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
@Setter
@Entity
@Table(name="t_magazin")
public class Magazin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "magazin", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Birou> birouList;

    @OneToMany(mappedBy = "magazin", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Scaun> scaunList;

    @OneToMany(mappedBy = "magazin", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Biblioteca> bibliotecaList;

    @OneToMany(mappedBy = "magazin", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Raft> raftList;

    @OneToMany(mappedBy = "magazin", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comoda> comodaList;
}