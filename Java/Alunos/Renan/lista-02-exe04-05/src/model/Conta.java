package model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

public class Conta {

	private static int instancias = 0;
	private static int criadas = 0;

	protected Timestamp criacao;
	protected long numero;
	protected Pessoa dono;
	protected double saldo;

	private ArrayList<Transacao> transacoes =  new ArrayList<Transacao>();

	public Conta() {
		this.saldo = 0;
		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		this.criacao = new java.sql.Timestamp(now.getTime());
		Conta.criadas++;
		Conta.instancias++;
	}

	public Conta(long numero, Pessoa dono) {
		this.saldo = 0;
		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		this.criacao = new java.sql.Timestamp(now.getTime());
		Conta.criadas++;
		Conta.instancias++;
	}

	public Conta(long numero, Pessoa dono, Timestamp criacao) {
		this.numero = numero;
		this.dono = dono;
		this.saldo = 0;
		this.criacao = criacao;
		Conta.criadas++;
		Conta.instancias++;
	}
	
	private void registrarTransacao(double valor) {
		this.transacoes.add(new Transacao(valor));
	}

	public void deposita(double valor) {
		this.saldo += valor;
		this.registrarTransacao(valor);
	}

	public double retira(double valor) {
		this.saldo -= valor;
		this.registrarTransacao(valor);
		return valor;
	}

	public Conta transfere(double valor, Conta contaDestino) {
		contaDestino.saldo += contaDestino.retira(valor);
		this.registrarTransacao(valor);
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

	public Timestamp getCriacao() {
		return criacao;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public Pessoa getDono() {
		return dono;
	}

	public void setDono(Pessoa dono) {
		this.dono = dono;
	}

	public String mostrarTransacoes() {
		return this.mostrarTransacoes(0);
	}

	public String mostrarTransacoes(int n) {

		StringBuilder sb = new StringBuilder();

		if (n == 0 || n > this.transacoes.size()) {
			for (Transacao t : this.transacoes) {
				sb.append(t.toString()+"\n");
			}
		} else {
			for (int i = 0; i < n; i++) {
				sb.append(this.transacoes.get(this.transacoes.size() - i).toString()+"\n");
			}
		}

		return sb.toString();
	}

	public String toString() {
		return "\n\t Conta nº" + this.numero + "\n\t Saldo:\tR$ "+this.saldo
				+ "\n\t Criada em:\t" + this.criacao.toString()
				+ "\n\t\tDados do Dono da Conta:" + this.dono.toString();
	}

}
