package model;

import java.awt.Point;

public abstract class Guerreiro extends Personagem {

	protected Arma arma;

	public Guerreiro(Lado lado, int vida, int percepcao, Arma arma) {
		super(lado, vida, true, percepcao);
		this.arma = arma;
	}

	public Guerreiro(Lado lado, int vida, int percepcao, Arma arma, Point posicao_atual) {
		this(lado, vida, percepcao, arma);
		this.posicao_atual = posicao_atual;
	}
	
	public Arma atacar() {
		return this.arma;
	}
}
