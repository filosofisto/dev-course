package com.javabasico;

public class Veiculo {

    private String placa;
    private String marca;
    private String renavam;

    public Veiculo(String placa, String marca, String renavam) {
        this.placa = placa;
        this.marca = marca;
        this.renavam = renavam;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }
}
