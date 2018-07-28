package model;

import java.sql.Timestamp;
import java.util.Calendar;

public class Transacao {

	private static int criadas = 0;
	private static int instancias = 0;
	
	protected long numero;

	protected Timestamp data;
	protected double valor;

	public Transacao(double valor) {
		this.valor = valor;
		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		this.data = new java.sql.Timestamp(now.getTime());
		Transacao.criadas++;
		this.numero =Transacao.criadas; 
		Transacao.instancias++;
	}

	public Transacao(Timestamp data, double valor) {
		this.data = data;
		this.valor = valor;
		Transacao.criadas++;
		this.numero =Transacao.criadas;
		Transacao.instancias++;
	}
	
	public static int getTotalDeInstanciasCriadas() {
		return Transacao.criadas;
	}

	public static int getQuantidadeDeInstancias() {
		return Transacao.instancias;
	}

	public Timestamp getData() {
		return data;
	}

	public double getValor() {
		return valor;
	}
	
	protected void finalize() {
		Transacao.instancias--;
	}
	
	public String toString() {
		return 
				 "\n\t Transação nº"+this.numero
				 + "\n\t Realizada em:\t"+this.data
				 + "\n\t Valor:\tR$ "+this.valor;
	}

}
