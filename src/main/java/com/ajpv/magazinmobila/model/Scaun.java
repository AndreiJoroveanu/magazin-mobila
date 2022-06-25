package com.ajpv.magazinmobila.model;

public class Scaun extends Mobila{
    private int maxWeight;
    public Scaun(int nr, String category, String name, String color, String material, int maxWeight, double height, double length, double width) {
        super(nr, category, name, color, material, height, length, width);
        this.maxWeight = maxWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }
}
