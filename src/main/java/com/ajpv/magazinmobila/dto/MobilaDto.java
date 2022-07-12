package com.ajpv.magazinmobila.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@Setter
@SuperBuilder
public class MobilaDto {
    private int id;
    private String category;
    private String name;
    private String color;
    private String material;
    private BigDecimal price;
    private String magazinName;

    public MobilaDto(int id, String category, String name, String color, String material, BigDecimal price, String magazinName) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.color = color;
        this.material = material;
        this.price = price;
        this.magazinName = magazinName;
    }
}