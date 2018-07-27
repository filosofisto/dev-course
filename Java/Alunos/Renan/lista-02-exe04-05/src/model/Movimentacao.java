package model;

import java.sql.Timestamp;
import java.util.Calendar;

public class Movimentacao {

	private static int criadas = 0;
	private static int instancias = 0;

	protected Timestamp data;
	protected double valor;

	public Movimentacao(double valor) {
		this.valor = valor;
		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		this.data = new java.sql.Timestamp(now.getTime());
		Movimentacao.criadas++;
		Movimentacao.instancias++;
	}

	public Movimentacao(Timestamp data, double valor) {
		this.data = data;
		this.valor = valor;
		Movimentacao.criadas++;
		Movimentacao.instancias++;
	}
	
	public static int getTotalDeInstanciasCriadas() {
		return Movimentacao.criadas;
	}

	public static int getQuantidadeDeInstancias() {
		return Movimentacao.instancias;
	}

	public Timestamp getData() {
		return data;
	}

	public double getValor() {
		return valor;
	}
	
	protected void finalize() {
		Movimentacao.instancias--;
	}

}
