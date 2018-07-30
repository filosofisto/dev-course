package model;

import java.awt.Point;

public class Arqueiro extends Guerreiro {

	private static int instancias_arqueiro = 0;
	private static int arqueiros_criados = 0;

	public Arqueiro(Lado lado) {
		super(lado, 25, 100, Arma.ARCO);
		Arqueiro.instancias_arqueiro++;
		Arqueiro.arqueiros_criados++;
	}

	public Arqueiro(Lado lado, Point posicao) {
		super(lado, 25, 100, Arma.ARCO, posicao);
		Arqueiro.instancias_arqueiro++;
		Arqueiro.arqueiros_criados++;
	}

	public static int quantidadeDeInstancias() {
		return Arqueiro.instancias_arqueiro;
	}

	public static int quantidadeDeInstanciasCriadas() {
		return Arqueiro.arqueiros_criados;
	}

	public void finalize() {
		Arqueiro.instancias_arqueiro--;
	}

}
