package com.cursojava;

public interface Figura {

    Ponto getPonto();

    void setPonto(Ponto ponto);

    double getArea();

    double getPerimetro();

    default double distancia(Figura f1, Figura f2) {
        return Math.sqrt(
                Math.pow(f2.getPonto().getX()-f1.getPonto().getX(),2)
                + Math.pow(f2.getPonto().getY()-f1.getPonto().getY(),2)
        );
    }
}
