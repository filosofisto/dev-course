package com.javabasico;

public class Quadrado extends Retangulo {

	public Quadrado(double lado) {
		super(lado, lado);
	}

	
	public boolean equals(Object object) {
		if (super.equals(object) && object instanceof Quadrado) {
			Quadrado outro = (Quadrado) object;

			return outro.getAltura() == this.getAltura();

		} else {

			return false;
			
		}
	}

	public double getLado() {
		return this.getAltura();
	}

	public void setLado(double lado) {
		this.setAltura(lado);
		this.setBase(lado);
	}

	public void setAltura(double lado) {
		this.setAltura(lado);
		this.setBase(lado);
	}

	public void setBase(double lado) {
		this.setAltura(lado);
		this.setBase(lado);
	}

}
