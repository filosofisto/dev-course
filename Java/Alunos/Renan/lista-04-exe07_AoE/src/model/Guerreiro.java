package model;

import java.awt.Point;

public abstract class Guerreiro extends Personagem {

	private static int instancias_guerreiro = 0;
	private static int guerreiros_criados = 0;

	protected Arma arma;

	public Guerreiro(Lado lado, int vida, int percepcao, Arma arma) {
		super(lado, vida, percepcao);
		this.arma = arma;

		Guerreiro.instancias_guerreiro++;
		Guerreiro.guerreiros_criados++;
	}

	public Guerreiro(Lado lado, int vida, int percepcao, Arma arma, Point posicao) {
		super(lado, vida, percepcao, posicao);
		this.arma = arma;
		Guerreiro.instancias_guerreiro++;
		Guerreiro.guerreiros_criados++;
	}

	public boolean podeAtacar(Personagem inimigo) {
		return inimigo.getLado() != this.lado && this.posicao.distance(inimigo.getPosicao()) <= this.arma.getAlcance();
	}

	public Personagem atacar(Personagem personagem) {
		if (podeAtacar(personagem)) {
			personagem.receberDano(this.arma.getDano());
		}
		return personagem;
	}

	@Override
	public String toString() {
		return super.toString() + " Guerreiro [arma=" + arma + "]";
	}

	public static int quantidadeDeInstancias() {
		return Guerreiro.instancias_guerreiro;
	}

	public static int quantidadeDeInstanciasCriadas() {
		return Guerreiro.guerreiros_criados;
	}

	@Override
	public void finalize() throws Throwable {
		super.finalize();
		--Guerreiro.instancias_guerreiro;
	}
}
