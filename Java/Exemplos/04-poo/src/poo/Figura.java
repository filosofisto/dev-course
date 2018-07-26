package poo;

public abstract class Figura {

	Ponto ponto;
	
	public Figura() {
		super();
		ponto = new Ponto();
	}

	public Ponto getPonto() {
		return ponto;
	}

	public void setPonto(Ponto ponto) {
		this.ponto = ponto;
	}
	
	public abstract double area();
	
	public abstract double perimetro();

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Figura) {
			Figura outra = (Figura) obj;
			return getPonto().equals(outra.getPonto());
		}
		
		return false;
	}
	
	public void mover(Ponto destino) {
		setPonto(destino);
	}
}
