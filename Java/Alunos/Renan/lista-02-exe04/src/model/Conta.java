package model;

public class Conta {

	private static int instancias = 0;
	private static int criadas = 0;

	protected long numero;
	protected Pessoa dono;
	protected double saldo;

	public Conta() {
		Conta.criadas++;
		Conta.instancias++;
	}

	public Conta(long numero, Pessoa dono, double valor) {
		this.numero = numero;
		this.dono = dono;
		this.saldo = valor;
		Conta.criadas++;
		Conta.instancias++;
	}

	public void deposita(double valor) {
		this.saldo += valor;
	}

	public double retira(double valor) {
		this.saldo -= valor;
		return valor;
	}

	public Conta transfere(double valor,Conta contaDestino) {
		contaDestino.saldo += this.retira(valor);
		return contaDestino;
	}
	
	public double getSaldoAtual() {
		return this.saldo;
	}

	public static int getTotalDeInstanciasCriadas() {
		return Conta.criadas;
	}

	public static int getQuantidadeDeInstancias() {
		return Conta.instancias;
	}

	protected void finalize() {
		Conta.instancias--;
	}



}
