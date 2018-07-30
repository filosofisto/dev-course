package model;

//	Concentrando os atributos das classes em um único lugar.
public enum Classe {
	ARQUEIRO(Arma.ARCO, 100, 1), CAVALEIRO(Arma.LANCA, 75, 100), SOLDADO(Arma.ESPADA, 50, 50), OPERARIO(35, 35);

	private Arma arma;
	private int percepcao;
	private int vida_maxima;

	Classe(Arma arma, int percepcao, int vida_maxima) {
	}

	Classe(int percepcao, int vida_maxima) {
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	public int getPercepcao() {
		return percepcao;
	}

	public void setPercepcao(int percepcao) {
		this.percepcao = percepcao;
	}

	public int getVida_maxima() {
		return vida_maxima;
	}

	public void setVida_maxima(int vida_maxima) {
		this.vida_maxima = vida_maxima;
	}

}
