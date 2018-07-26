package com.javabasico;

public class Circulo extends Figura {

	private double raio;
	
	public Circulo(double raio) {
		this.raio = raio;
	}
	
	public double distancia(Ponto destino) {
		return Math.sqrt(
				Math.pow(destino.getX()-ponto.getX(), 2) + 
				Math.pow(destino.getY()-ponto.getY(), 2)
		);
	}

	@Override
	public double perimetro() {
		return 2*Math.PI*raio;
	}

	@Override
	public double area() {
		return Math.PI*Math.pow(raio, 2);
	}
}
