package com.javabasico;

public abstract class Figura {

	protected Ponto ponto;

	public abstract double perimetro();
	
	public abstract double area();
	
	public Ponto getPonto() {
		return ponto;
	}
	public void setPonto(Ponto ponto) {
		this.ponto = ponto;
	}
	
}
