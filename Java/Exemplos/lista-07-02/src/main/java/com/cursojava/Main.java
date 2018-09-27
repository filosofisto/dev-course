package com.cursojava;

public class Main {

    public static void main(String[] args) {
        Circulo c = new Circulo();
        c.setPonto(new Ponto(0,0));

        Retangulo r = new Retangulo();
        r.setPonto(new Ponto(1,1));

        System.out.println(c.distancia(c, r));
    }
}
