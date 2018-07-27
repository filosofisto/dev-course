package model;

import java.awt.Point;

public class Soldado extends Guerreiro {

	public Soldado(Lado lado, Point posicao) {
		super(lado, 50, 10, Arma.ESPADA, posicao);
	}
	

}
