package com.ajpv.magazinmobila.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


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
    private double height;
    private double length;
    private double width;
    private double price;

    public Mobila(int id, String category, String name, String color, String material, double height, double length, double width, double price) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.color = color;
        this.material = material;
        this.height = height;
        this.length = length;
        this.width = width;
        this.price = price;
    }
}
