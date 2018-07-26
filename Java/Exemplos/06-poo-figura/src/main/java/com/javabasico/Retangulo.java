package com.javabasico;

public class Retangulo extends Figura {

	double largura;
	double altura;
	
	public Retangulo(double largura, double altura) {
		setLargura(largura);
		setAltura(altura);
	}
	
	@Override
	public double area() {
		return largura*altura;
	}

	@Override
	public double perimetro() {
		return 2*(largura+altura);
	}

	public double getLargura() {
		return largura;
	}

	public void setLargura(double largura) {
		this.largura = largura;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	
}


