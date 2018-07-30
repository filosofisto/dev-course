package model;

import java.awt.Point;

public class Cavaleiro extends Guerreiro {

	public Cavaleiro(Lado lado) {
		super(lado, Classe.CAVALEIRO);
	}

	
	public Cavaleiro(Lado lado, Point posicao) {
		super(lado, Classe.CAVALEIRO, posicao);
	}

}
