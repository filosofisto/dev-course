package com.cursojava;

public abstract class AbstractFigura implements Figura {

    private Ponto ponto;

    public Ponto getPonto() {
        return ponto;
    }

    public void setPonto(Ponto ponto) {
        this.ponto = ponto;
    }
}
