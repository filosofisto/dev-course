package com.cursojava;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//@XmlRootElement(name="conta")
@XmlType(propOrder = {"cpf", "banco", "agencia"/*, "saldo"*/})
public class Conta {

    private String cpf;
    private String banco;
    private String agencia;
    //private double saldo;

    @XmlElement(name = "banco")
    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    @XmlElement(name = "agencia")
    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    @XmlElement(name = "cpf")
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /*@XmlElement(name = "saldo")
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }*/

    @Override
    public String toString() {
        return "Conta{" +
                "banco='" + banco + '\'' +
                ", agencia='" + agencia + '\'' +
                ", cpf='" + cpf + '\'' +
                //", saldo=" + saldo +
                '}';
    }
}
