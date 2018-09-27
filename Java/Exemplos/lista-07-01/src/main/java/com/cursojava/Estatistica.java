package com.cursojava;

import java.util.List;

public class Estatistica {

    public double media(List<Double> values) {
        if (values.size() == 0) {
            return 0;
        }

        final DoubleWrapper total = new DoubleWrapper();

        /*for (double value: values) {
            total += value;
        }*/

        values.forEach(value -> total.sum(value));

        return total.getValue()/values.size();
    }
}

class DoubleWrapper {

    private double value = 0;

    public void sum(double otherValue) {
        value += otherValue;
    }

    public double getValue() {
        return value;
    }
}