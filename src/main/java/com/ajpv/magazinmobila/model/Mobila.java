package com.ajpv.magazinmobila.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Mobila {
    private int nr;
    private String category;
    private String name;
    private String color;
    private String material;
    private double height;
    private double length;
    private double width;
    private double price;

    /*
    public Mobila(int nr, String category, String name, String color, String material, double height, double length, double width, double price) {
        this.nr = nr;
        this.category = category;
        this.name = name;
        this.color = color;
        this.material = material;
        this.height = height;
        this.length = length;
        this.width = width;
        this.price = price;
    }
    */
}
