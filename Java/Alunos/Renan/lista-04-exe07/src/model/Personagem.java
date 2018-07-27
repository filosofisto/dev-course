package model;

import java.awt.Point;

public abstract class Personagem {
	
	protected boolean lado;
	
	protected Point posicao_atual;
	protected Point destino;
	
	protected int vida;
	protected Status estado;
	protected boolean pode_atacar;
	protected int percepcao;	//	<-- A remover, não vai ser utilizado.
	
	public Personagem(Lado lado, int vida, boolean pode_atacar, int percepcao) {
	}
	
	
	public void mover() {
		this.posicao_atual.translate(destino.x, destino.y);
	}
	
	public void recebeDano(Arma arma) {
		this.vida -= arma.getDano();
	}
	
	
	public boolean estaVivo() {
		return this.vida > 0;
	}
	
	public void acao() {
		
	}
	
}
