package model;

import java.awt.Color;

public enum Lado {
	ALIADO(new Color(0, 0, 255)), INIMIGO(new Color(255, 0, 0));

	private Color cor;

	Lado(Color cor) {
		this.cor = cor;
	}

	public Color getCor() {
		return cor;
	}

	public void setCor(Color cor) {
		this.cor = cor;
	}

}
