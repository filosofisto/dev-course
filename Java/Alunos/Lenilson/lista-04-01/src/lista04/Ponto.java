package lista04;

public class Ponto {
	protected int x;
	protected int y;
	
	private static int count = 0;
	
	public Ponto() {
		x = 0;
		y = 0;
		count++;
	}
	
	public Ponto (int x, int y) {
		setX(x);
		setY(y);
		count++;
	}

	public static int getCount() {
		return count;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "("+x+", "+y+")";
	}
	
	@Override
	public boolean equals(Object object) {
		if (object != null && object instanceof Ponto) {
			Ponto p = (Ponto) object;
			return getX() == p.getX() && getY() == p.getY();
		}
		
		return false;
	}
	
	public Ponto getClone() {
		return new Ponto(x, y);
	}
	
	public float distancia(Ponto p) {
		return (float) Math.sqrt(Math.pow((p.getX() - getX()), 2) + Math.pow((p.getY() - getY()), 2));
	}
}
