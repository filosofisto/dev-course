package com.cursojava;

class CalculoNota {

    public double mediaAritmetica(double[] valores) {
        if (valores.length == 0)
            return 0;

        double soma = 0;

        for (double valor: valores) {
            soma += valor;
        }

        return soma/valores.length;
    }

    public double mediaPonderada(double[] valores, int[] pesos) throws Exception {
        if (valores.length != pesos.length) {
            throw new Exception("Tamanhos dos arrays diferente");
        }

        if (valores.length == 0) {
            return 0;
        }

        double soma = 0;
        int somaPesos = 0;

        for (double valor: valores) {
            soma += valor;
        }

        for (int peso: pesos) {
            somaPesos += peso;
        }

        return soma/somaPesos;
    }
}
