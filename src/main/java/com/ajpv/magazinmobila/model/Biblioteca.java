package com.ajpv.magazinmobila.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@NoArgsConstructor
@Setter
@SuperBuilder
@Entity
@Table(name="t_biblioteca")
public class Biblioteca extends Mobila{
    public Biblioteca(int id, String category, String name, String color, String material, double height, double length, double width, double price) {
        super(id, category, name, color, material, height, length, width, price);
    }
}
