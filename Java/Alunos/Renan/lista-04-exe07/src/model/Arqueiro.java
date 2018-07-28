package model;

import java.awt.Point;

public class Arqueiro extends Guerreiro {

	public Arqueiro(Lado lado, Point posicao) {
		super(lado, 1, 100, Arma.ESPADA, posicao);
	}


}
