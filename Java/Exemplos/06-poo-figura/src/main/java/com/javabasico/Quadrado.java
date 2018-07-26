package com.javabasico;

public class Quadrado extends Retangulo {

	public Quadrado(double lado) {
		super(lado, lado);
	}
<<<<<<< HEAD

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

=======
>>>>>>> 97744895e6c1f22dd27b684de181326483e15e86
}
