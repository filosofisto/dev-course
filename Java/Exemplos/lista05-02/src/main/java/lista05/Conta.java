package lista05;

import java.io.Serializable;

public class Conta implements Serializable {

    @Substring(inicio = 0, fim = 5)
    private String banco;

    @Substring(inicio = 5, fim = 11)
    private String agencia;

    @Substring(inicio = 11, fim = 22)
    private String cpf;

    @Substring(inicio = 22, fim = 40)
    private Double saldo;

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
