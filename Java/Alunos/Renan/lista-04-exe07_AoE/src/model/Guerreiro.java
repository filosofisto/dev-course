package model;

import java.awt.Point;

public abstract class Guerreiro extends Personagem {

	protected Arma arma;

	
	public Guerreiro(Lado lado, Classe classe) {
		super(lado);
		this.classe = classe;
		this.aplicarAtributos();
		
		this.percepcao = classe.getPercepcao();
		this.vida = classe.getVida_maxima();

	}
	
	public Guerreiro(Lado lado, Classe classe, Point posicao) {
		super(lado, posicao);
		this.classe = classe;
		this.aplicarAtributos();
		
		this.percepcao = classe.getPercepcao();
		this.vida = classe.getVida_maxima();

	}	
	
	@Override
	protected void aplicarAtributos() {
		super.aplicarAtributos();
		this.arma = classe.getArma();
	}

	public Personagem atacar(Personagem personagem) {
		personagem.receberDano(this.arma.getDano());
		return personagem;
	}
}
