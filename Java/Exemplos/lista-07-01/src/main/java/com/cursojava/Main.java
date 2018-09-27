package com.cursojava;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Estatistica estatistica = new Estatistica();

        List<Double> values = new ArrayList<>();
        values.add(8d);
        values.add(9d);
        values.add(10d);

        System.out.println(estatistica.media(values));
    }
}
