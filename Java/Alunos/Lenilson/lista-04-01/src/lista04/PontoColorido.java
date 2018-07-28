package lista04;

public class PontoColorido extends Ponto{
	protected String cor;
	
	public PontoColorido() {
		cor = "Incolor";
	}
	
	public PontoColorido (int x, int y, String cor) {
		super(x, y);
		setCor(cor);
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	@Override
	public String toString() {
		return "("+x+", "+y+") Cor: "+cor;
	}
	
	@Override
	public boolean equals(Object object) {
		if (super.equals(object) && object instanceof PontoColorido) {
			PontoColorido p = (PontoColorido) object;
			return getCor().equals(p.getCor());
		}
		
		return false;
	}
	
	@Override
	public PontoColorido getClone() {
		return new PontoColorido(x, y, cor);
	}
	
}
