package poo;

public class Ponto implements Cloneable{

	protected int x;
	protected int y;
	
	public Ponto() {
		x = 0;
		y = 0;
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
        try {
            // call clone in Object.
            return (Ponto) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println (" Cloning not allowed. " );
            return this;
        }
    }
}
