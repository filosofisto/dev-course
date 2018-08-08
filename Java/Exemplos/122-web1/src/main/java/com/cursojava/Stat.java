package com.cursojava;

import java.util.ArrayList;
import java.util.List;

public class Stat {

    private List<Long> valores;

    Stat() {
        valores = new ArrayList<>();
    }

    public void add(long tempo) {
        valores.add(tempo);
    }

    public double media() {
        double sum = 0;

        if (valores.isEmpty()) {
            return 0;
        }

        for (long valor: valores) {
            sum += valor;
        }

        return sum/valores.size();
    }
}
