package model;

import java.awt.Point;

public class Cavaleiro extends Guerreiro {

	private static int instancias_cavaleiro = 0;
	private static int cavaleiros_criados = 0;

	public Cavaleiro(Lado lado) {
		super(lado, 100, 75, Arma.LANCA);
		Cavaleiro.instancias_cavaleiro++;
		Cavaleiro.cavaleiros_criados++;
	}

	public Cavaleiro(Lado lado, Point posicao) {
		super(lado, 100, 75, Arma.LANCA, posicao);
		Cavaleiro.instancias_cavaleiro++;
		Cavaleiro.cavaleiros_criados++;
	}

	public static int quantidadeDeInstancias() {
		return Cavaleiro.instancias_cavaleiro;
	}

	public static int quantidadeDeInstanciasCriadas() {
		return Cavaleiro.cavaleiros_criados;
	}

	public void finalize() throws Throwable {
		super.finalize();
		--Cavaleiro.instancias_cavaleiro;
	}

}
