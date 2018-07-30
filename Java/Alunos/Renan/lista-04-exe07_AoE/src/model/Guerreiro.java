package model;

import java.awt.Point;

public abstract class Guerreiro extends Personagem {

	private static int instancias_guerreiro = 0;
	private static int guerreiros_criados = 0;

	protected Arma arma;

	public Guerreiro(Lado lado, Classe classe) {
		super(lado);
		this.classe = classe;
		this.aplicarAtributos();

		Guerreiro.instancias_guerreiro++;
		Guerreiro.guerreiros_criados++;
	}

	public Guerreiro(Lado lado, Classe classe, Point posicao) {
		super(lado, posicao);
		this.classe = classe;
		this.aplicarAtributos();

		this.percepcao = classe.getPercepcao();
		this.vida = classe.getVida_maxima();

		Guerreiro.instancias_guerreiro++;
		Guerreiro.guerreiros_criados++;
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

	public static int quantidadeDeInstancias() {
		return Guerreiro.instancias_guerreiro;
	}

	public static int quantidadeDeInstanciasCriadas() {
		return Guerreiro.guerreiros_criados;
	}

	public void finalize() {
		Guerreiro.instancias_guerreiro--;
	}
}
