package model;

public class Ponto3D extends Ponto {
	protected double z;

	private static int count3D;

	public Ponto3D() {
		Ponto3D.count3D++;
	}

	public Ponto3D(double x, double y, double z) {
		super(x, y);
		this.z = z;
		Ponto3D.count3D++;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	@Override
	public double distancia(Ponto destino) {
		return this.distancia(new Ponto3D(destino.x, destino.y, 0));
	}

	public double distancia(Ponto3D destino) {
		return Math.sqrt(
				Math.pow(this.x - destino.x, 2) + Math.pow(this.y - destino.y, 2) + Math.pow(this.z - destino.z, 2));
	}

	public static int getQuantidadeDePontos3D() {
		return Ponto3D.count3D;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ponto3D other = (Ponto3D) obj;
		if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z))
			return false;
		return true;
	}

	public Ponto3D getClone() {
		try {
			// Call clone in Object.
			return (Ponto3D) super.clone();
		} catch (CloneNotSupportedException e) {
			// Cloning not allowed
			return this;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ", " + z + ")";
	}

	protected void finalize() {
		super.finalize();
		Ponto3D.count3D--;
	}
}
