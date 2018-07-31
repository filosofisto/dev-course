package model;

public enum Arma {
	ARCO(5, 10, 5), ESPADA(35, 1, 5), LANCA(25, 2, 1);

	private int dano;
	private int alcance;
	private int peso;

	Arma(int dano, int alcance, int peso) {
		this.dano = dano;
		this.alcance = alcance;
		this.peso = peso;
	}

	public int getDano() {
		return dano;
	}

	public void setDano(int dano) {
		this.dano = dano;
	}

	public int getAlcance() {
		return alcance;
	}

	public void setAlcance(int alcance) {
		this.alcance = alcance;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

}
