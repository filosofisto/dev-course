package model;

import java.awt.Point;

public class Operario extends Personagem{

	public Operario(Lado lado, Point posicao) {
		super(lado, 25, false, 100);
		this.posicao_atual = posicao;
	}

}
