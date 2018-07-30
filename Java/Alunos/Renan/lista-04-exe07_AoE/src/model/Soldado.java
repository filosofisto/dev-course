package model;

import java.awt.Point;

public class Soldado extends Guerreiro{

	
	public Soldado(Lado lado) {
		super(lado, Classe.SOLDADO);
	}
	
	public Soldado(Lado lado, Point posicao) {
		super(lado, Classe.SOLDADO, posicao);
	}

}
