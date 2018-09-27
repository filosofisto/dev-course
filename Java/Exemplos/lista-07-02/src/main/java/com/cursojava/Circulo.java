package com.cursojava;

public class Circulo extends AbstractFigura {

    private double raio;

    public double getArea() {
        return Math.PI*raio*raio;
    }

    public double getPerimetro() {
        return 2*Math.PI*raio;
    }
}
