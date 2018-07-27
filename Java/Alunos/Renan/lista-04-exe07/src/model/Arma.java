package model;

public enum Arma {
	ESPADA(10, 1, 5), ARCO(1, 10, 5), LANCA(5, 2, 1);

	private int alcance;
	private int dano;
	private int peso;

	Arma(int alcance, int dano, int peso) {
		this.alcance = alcance;
		this.dano = dano;
		this.peso = peso;
	}

	public int getAlcance() {
		return this.alcance;
	}

	public int getDano() {
		return this.dano;
	}

	public int getPeso() {
		return this.peso;
	}

}
