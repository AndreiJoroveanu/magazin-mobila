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
}
