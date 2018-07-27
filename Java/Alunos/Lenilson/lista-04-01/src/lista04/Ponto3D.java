package lista04;

public class Ponto3D extends Ponto{
	protected int z;
	
	public Ponto3D() {
		super();
		z = 0;
	}
	
	public Ponto3D (int x, int y, int z) {
		super(x, y);
		setZ(z);
	}
	
	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}
	
	@Override
	public String toString() {
		return "("+x+", "+y+", "+z+")";
	}
	
	@Override
	public boolean equals(Object object) {
		if (super.equals(object) && object instanceof Ponto3D) {
			Ponto3D p = (Ponto3D) object;
			return getZ() == p.getZ();
		}
		
		return false;
	}
	
	@Override
	public Ponto3D getClone() {
		return new Ponto3D(x, y, z);
	}
	
	public float distancia(Ponto3D p) {
		return (float) Math.sqrt(Math.pow((p.getX() - getX()), 2) + Math.pow((p.getY() - getY()), 2) + Math.pow((p.getZ() - getZ()), 2));
	}
}
