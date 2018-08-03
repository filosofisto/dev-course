package com.cursojava;

import org.junit.Assert;
import org.junit.Test;

public class CalculoNotaTest {

    @Test
    public void testMediaAritmetica() {
        CalculoNota calculoNota = new CalculoNota();
        double media = calculoNota.mediaAritmetica(new double[] { 1, 3 });

        Assert.assertEquals(2, media, 0);
    }

    @Test(expected = Exception.class)
    public void testeValoresNullAritmetica() {
        new CalculoNota().mediaAritmetica(null);
    }

    @Test
    public void testeVaziosAritmetica() {
        CalculoNota calculoNota = new CalculoNota();
        double media = calculoNota.mediaAritmetica(new double[] {});

        Assert.assertEquals(0, media, 0);
    }

    @Test
    public void testeMediaAritmetica() throws Exception {
        double[] valores = { 1, 2, 3 };
        int[] pesos = {1, 1, 1};

        CalculoNota calculoNota = new CalculoNota();
        double media = calculoNota.mediaPonderada(valores, pesos);

        Assert.assertEquals(2, media, 2);
    }

    @Test(expected = Exception.class)
    public void testeArrayTamanhosDiferentes() throws Exception {
        double[] valores = { 1, 2, 3 };
        int[] pesos = {1, 2};

        CalculoNota calculoNota = new CalculoNota();
        calculoNota.mediaPonderada(valores, pesos);
    }

    @Test(expected = Exception.class)
    public void testeValoresNull() throws Exception {
        new CalculoNota().mediaPonderada(null, new int[] {1});
    }

    @Test(expected = Exception.class)
    public void testePesosNull() throws Exception {
        new CalculoNota().mediaPonderada(new double[] {1}, null);
    }

    @Test
    public void testeVazios() throws Exception {
        CalculoNota calculoNota = new CalculoNota();
        double media = calculoNota.mediaPonderada(new double[] {}, new int[] {});

        Assert.assertEquals(0, media, 0);
    }
}
