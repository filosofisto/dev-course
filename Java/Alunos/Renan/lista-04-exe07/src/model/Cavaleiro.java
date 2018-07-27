package model;

import java.awt.Point;

public class Cavaleiro extends Guerreiro{

	public Cavaleiro(Lado lado, Point posicao) {
		super(lado, 100, 25, Arma.LANCA, posicao);
	}
	
}
