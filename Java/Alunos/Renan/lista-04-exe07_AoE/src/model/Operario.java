package model;

import java.awt.Point;

public class Operario extends Personagem{

	
	public Operario(Lado lado) {
		super(lado, Classe.OPERARIO);
	}
	
	public Operario(Lado lado, Point posicao) {
		super(lado, Classe.OPERARIO, posicao);
	}
	
}
