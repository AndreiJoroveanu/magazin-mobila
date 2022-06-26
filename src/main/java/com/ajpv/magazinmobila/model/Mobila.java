package com.ajpv.magazinmobila.model;

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

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
