package com.cursojava;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.junit.Before;

import static org.junit.Assert.*;

public class Stepdefs {

    private CalculoNota calculoNota;
    private double[] valores;
    private double media;

    public Stepdefs() {
        this.calculoNota = new CalculoNota();
    }

    @Given("Informo os valores \"(.*)\" e \"(.*)\"")
    public void informoValores(String v1, String v2) {
        this.valores = new double[] {Double.parseDouble(v1), Double.parseDouble(v2)};
    }

    @When("Calculo a media aritmetica")
    public void calculoMediaAritmetica() {
        media = calculoNota.mediaAritmetica(valores);
    }

    @Then("A media aritmetica deve ser \"(.*)\"")
    public void resultadoMediaAritmetica(String valorEsperado) {
        assertEquals(Double.parseDouble(valorEsperado), media, 2);
    }
}