package lista04;

public class Posicao {
	protected int x;
	protected int y;
	
	public Posicao() {
		x = 0;
		y = 0;
	}
	
	public Posicao (int x, int y) {
		setX(x);
		setY(y);
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
		if (object != null && object instanceof Posicao) {
			Posicao p = (Posicao) object;
			return getX() == p.getX() && getY() == p.getY();
		}
		
		return false;
	}
	
	public Posicao getClone() {
		return new Posicao(x, y);
	}
	
	public float distancia(Posicao p) {
		return (float) Math.sqrt(Math.pow((p.getX() - getX()), 2) + Math.pow((p.getY() - getY()), 2));
	}
}
