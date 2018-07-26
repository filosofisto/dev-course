package poo;

public class Quadrado extends Retangulo {

	public Quadrado(double lado) {
		super(lado, lado);
	}

	@Override
	public boolean equals(Object object) {
<<<<<<< HEAD
		return super.equals(object) && object instanceof Quadrado;
=======
		return (super.equals(object) && object instanceof Quadrado);
>>>>>>> 605f8206e7bb34a8e3c7c215b91e64b326b85913
	}
	

	public double getLado() {
		return getAltura();
	}

	public void setLado(double lado) {
		this.setAltura(lado);
		this.setLargura(lado);
	}

	@Override
	public void setAltura(double lado) {
		this.setAltura(lado);
		this.setLargura(lado);
	}

<<<<<<< HEAD
=======
	@Override
>>>>>>> 605f8206e7bb34a8e3c7c215b91e64b326b85913
	public void setLargura(double lado) {
		this.setAltura(lado);
		this.setLargura(lado);
	}
	
	
}
