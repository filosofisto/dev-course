package model;

import java.awt.Color;

public enum Lado {
	ALIADO(new Color(255, 0, 0)), INIMIGO(new Color(0, 0, 255));

	private Color cor;

	Lado(Color cor) {
		this.cor = cor;
	}
	
	public Color getColor() {
		return this.cor;
	}

}
