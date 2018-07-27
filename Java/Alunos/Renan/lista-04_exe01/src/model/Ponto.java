package model;

public class Ponto implements Cloneable {

	private static int count = 0;

	protected double x;
	protected double y;

	public Ponto() {
		Ponto.count++;
	}

	public Ponto(double x, double y) {
		this.x = x;
		this.y = y;
		Ponto.count++;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double distancia(Ponto destino) {
		return Math.sqrt(Math.pow(this.x - destino.x, 2) + Math.pow(this.y - destino.y, 2));
	}

	public static int getQuantidadeDePontos() {
		return Ponto.count;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ponto other = (Ponto) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}

	public Ponto getClone() {
		try {
			// Call clone in Object.
			return (Ponto) super.clone();
		} catch (CloneNotSupportedException e) {
			// Cloning not allowed
			return this;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	protected void finalize() {
		Ponto.count--;
	}

}
