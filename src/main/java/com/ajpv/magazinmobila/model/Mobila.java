package com.ajpv.magazinmobila.model;

public class Mobila {
    private String tip;
    private String nume;
    private String culoare;
    private String material;
    private double inaltime;
    private double lungime;
    private double latime;

    public Mobila(String tip, String nume, String culoare, String material,
                  double inaltime, double lungime, double latime) {
        this.tip = tip;
        this.nume = nume;
        this.culoare = culoare;
        this.material = material;
        this.inaltime = inaltime;
        this.lungime = lungime;
        this.latime = latime;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getInaltime() {
        return inaltime;
    }

    public void setInaltime(int inaltime) {
        this.inaltime = inaltime;
    }

    public double getLungime() {
        return lungime;
    }

    public void setLungime(int lungime) {
        this.lungime = lungime;
    }

    public double getLatime() {
        return latime;
    }

    public void setLatime(int latime) {
        this.latime = latime;
    }
}
