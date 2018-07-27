package model;

import java.awt.Color;

public class PontoColorido extends Ponto {

	protected Color cor;

	private static int countPC = 0;

	public PontoColorido() {
		PontoColorido.countPC++;
	}

	public PontoColorido(double x, double y, Color cor) {
		super(x, y);
		this.cor = cor;
		PontoColorido.countPC++;
	}

	public PontoColorido(double x, double y) {
		super(x, y);
		PontoColorido.countPC++;
	}

	public PontoColorido(Color cor) {
		this.cor = cor;
		PontoColorido.countPC++;
	}

	public static int getQuantidadeDePontosColoridos() {
		return PontoColorido.countPC;
	}

	public PontoColorido getClone() {
		try {
			// Call clone in Object.
			return (PontoColorido) super.clone();
		} catch (CloneNotSupportedException e) {
			// Cloning not allowed
			return this;
		}
	}

	@Override
	public String toString() {
		return super.toString() + "[" + this.cor.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cor == null) ? 0 : cor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PontoColorido other = (PontoColorido) obj;
		if (cor == null) {
			if (other.cor != null)
				return false;
		} else if (!cor.equals(other.cor))
			return false;
		return true;
	}

	protected void finalize() {
		super.finalize();
		PontoColorido.countPC--;
	}

}
