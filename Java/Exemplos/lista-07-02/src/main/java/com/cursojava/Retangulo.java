package com.cursojava;

public class Retangulo extends AbstractFigura {

    private double base, altura;

    public double getArea() {
        return base*altura;
    }

    public double getPerimetro() {
        return 2*(base+altura);
    }
}
