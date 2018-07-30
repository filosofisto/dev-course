package model;

import java.awt.Point;

public class Arqueiro extends Guerreiro{
	
	
	public Arqueiro(Lado lado) {
		super(lado, Classe.ARQUEIRO);
	}
	
	public Arqueiro(Lado lado, Point posicao) {
		super(lado, Classe.ARQUEIRO, posicao);
	}

}
