package com.javabasico;

public class Ponto3D extends Ponto {
	
	protected double z;
	
	public Ponto3D(double x, double y, double z) {
		super(x,y);
		setZ(z);
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}
}
