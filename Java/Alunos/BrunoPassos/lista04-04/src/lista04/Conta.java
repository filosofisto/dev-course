package lista04;

import java.math.BigDecimal;
import java.util.List;

import com.sun.corba.se.impl.ior.GenericTaggedComponent;

public class Conta {

	private int numero;
	private int agencia;
	private double saldo;

	public Conta(int numero, int agencia) {
		super();
		setNumero(numero);
		setAgencia(agencia);
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void deposita(double valor) throws Exception {
		if (valor > 0) {
			this.saldo += valor;
		} else {
			//System.out.println("Valor informado � invalido");
			throw new Exception("Valor informado invalido");
		}

	}

	public void saca(double valor) {

		if (valor <= this.saldo) {
			this.saldo -= valor;
		} else {
			System.out.println("Saldo insuficiente");
		}
	}

	public void transfere(double valor, Conta conta) {
		if (valor > this.saldo) {
			System.out.println("Saldo insuficiente para transferencia");
		} else if (valor <= this.saldo) {
			this.saldo -= valor;
			conta.setSaldo(valor);
			System.out.println("Transferencia realizada com sucesso");

		}
	}

}
