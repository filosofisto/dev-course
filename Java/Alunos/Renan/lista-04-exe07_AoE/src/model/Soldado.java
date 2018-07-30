package model;

import java.awt.Point;

public class Soldado extends Guerreiro {

	private static int instancias_soldado = 0;
	private static int soldados_criados = 0;

	public Soldado(Lado lado) {
		super(lado, 50, 50, Arma.ESPADA);
		Soldado.instancias_soldado++;
		Soldado.soldados_criados++;
	}

	public Soldado(Lado lado, Point posicao) {
		super(lado, 50, 75, Arma.ESPADA, posicao);
		Soldado.instancias_soldado++;
		Soldado.soldados_criados++;
	}

	public static int quantidadeDeInstancias() {
		return Soldado.instancias_soldado;
	}

	public static int quantidadeDeInstanciasCriadas() {
		return Soldado.soldados_criados;
	}

	public void finalize() {
		Soldado.instancias_soldado--;
	}

}
