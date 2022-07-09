package com.ajpv.magazinmobila.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
public class Mobila {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String category;
    private String name;
    private String color;
    private String material;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "id_store")
    private Magazin magazin;

    public Mobila(int id, String category, String name, String color, String material, BigDecimal price, Magazin magazin) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.color = color;
        this.material = material;
        this.price = price;
        this.magazin = magazin;
    }
}
