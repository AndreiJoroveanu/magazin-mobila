package com.ajpv.magazinmobila.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@Setter
@SuperBuilder
@Entity
@Table(name="t_scaun")
public class Scaun extends Mobila{
    private int maxWeight;

    public Scaun(int id, String category, String name, String color, String material, int maxWeight, BigDecimal price, Magazin magazin) {
        super(id, category, name, color, material, price, magazin);
        this.maxWeight = maxWeight;
    }
}
