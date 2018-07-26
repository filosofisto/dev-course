package poo;

public class Quadrado extends Retangulo {

	public Quadrado(double lado) {
		super(lado, lado);
	}

	@Override
	public boolean equals(Object object) {
		return super.equals(object) && object instanceof Quadrado;
	}

	public double getLado() {
		return getAltura();
	}

	public void setLado(double lado) {
		this.setAltura(lado);
		this.setLargura(lado);
	}

	public void setAltura(double lado) {
		this.setAltura(lado);
		this.setLargura(lado);
	}

	public void setLargura(double lado) {
		this.setAltura(lado);
		this.setLargura(lado);
	}

}
