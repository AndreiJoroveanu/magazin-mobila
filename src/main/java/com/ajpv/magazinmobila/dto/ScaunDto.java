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
public class ScaunDto extends MobilaDto{
    private int maxWeight;
    public ScaunDto(int id, String category, String name, String color, String material, int maxWeight, BigDecimal price, String magazinName) {
        super(id, category, name, color, material, price, magazinName);
        this.maxWeight = maxWeight;
    }
}