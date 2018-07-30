package model;

import java.awt.Point;

public abstract class Personagem {

	private static int instancias = 0;
	private static int criacoes = 0;

	protected Lado lado;
	protected Point posicao;
	protected Point destino;

	protected int vida;
	protected int percepcao;
	protected Estado estado = Estado.DESCANSANDO;

	public Personagem(Lado lado) {
		this.lado = lado;

		Personagem.instancias++;
		Personagem.criacoes++;
	}

	public Personagem(Lado lado, Point posicao) {
		this.lado = lado;
		this.posicao = posicao;
		this.destino = posicao;

		Personagem.instancias++;
		Personagem.criacoes++;
	}

	public Personagem(Lado lado, int vida, int percepcao, Point posicao) {
		this.lado = lado;
		this.vida = vida;
		this.percepcao = percepcao;
		this.posicao = posicao;
		this.destino = posicao;

		Personagem.instancias++;
		Personagem.criacoes++;
	}

	public Personagem(Lado lado, int vida, int percepcao) {
		this.lado = lado;
		;

		Personagem.instancias++;
		Personagem.criacoes++;
	}

	public boolean notaInimigo(Personagem inimigo) {
		if (inimigo.getLado() != this.lado) {
			return this.posicao.distance(inimigo.getPosicao()) <= this.percepcao;
		} else {
			return false;
		}
	}

	public void mover() {
		if (destino.equals(posicao)) {
			int x = 0;
			int y = 0;
			if (destino.x > posicao.x) {
				x = 1;
			} else if (destino.x < posicao.x) {
				x = -1;
			}
			if (destino.y > posicao.y) {
				y = 1;
			} else if (destino.y < posicao.y) {
				y = -1;
			}

			this.posicao.translate(posicao.x + x, posicao.y + y);
		}
	}

	public void receberDano(int dano) {
		this.vida -= dano;
	}

	public void receberDano(Arma arma) {
		this.vida -= arma.getDano();
	}

	public boolean isVivo() {
		return this.vida > 0;
	}

	public boolean isMorto() {
		return !isVivo();
	}

	public static int quantidadeDeInstancias() {
		return Personagem.instancias;
	}

	public static int quantidadeDeInstanciasCriadas() {
		return Personagem.criacoes;
	}

	public Lado getLado() {
		return lado;
	}

	public void setLado(Lado lado) {
		this.lado = lado;
	}

	public Point getPosicao() {
		return posicao;
	}

	public void setPosicao(Point posicao) {
		this.posicao = posicao;
	}

	public Point getDestino() {
		return destino;
	}

	public void setDestino(Point destino) {
		this.destino = destino;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getPercepcao() {
		return percepcao;
	}

	public void setPercepcao(int percepcao) {
		this.percepcao = percepcao;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String posicaoToString() {
		if (this.posicao != null) {
			return "(" + posicao.x + "," + posicao.y + ")";
		} else {
			return null;
		}
	}

	public String destinoToString() {
		if (this.destino != null) {
			return "(" + destino.x + "," + destino.y + ")";
		} else {
			return null;
		}
	}

	@Override
	public String toString() {
		return "Personagem [lado=" + lado + ", posicao=" + this.posicaoToString() + ", destino="
				+ this.destinoToString() + ", vida=" + vida + ", percepcao=" + percepcao + ", estado=" + estado + "]";
	}

}
