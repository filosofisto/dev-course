package lista04;

public class Ponto implements Cloneable {
	
	private static int count;

	int pontoX;
	int pontoY;

	public Ponto() {
		count++;
	}

	public Ponto(int pontoX, int pontoY) {
		super(); // duvida
		setPontoX(pontoX);
		setPontoY(pontoY);
		count++;
	}
	
	

	public static int getCount() {
		return count;
	}

	public int getPontoX() {
		return pontoX;
	}

	public void setPontoX(int pontoX) {
		this.pontoX = pontoX;
	}

	public int getPontoY() {
		return pontoY;
	}

	public void setPontoY(int pontoY) {
		this.pontoY = pontoY;
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
		if (pontoX != other.pontoX)
			return false;
		if (pontoY != other.pontoY)
			return false;
		return true;
	}

	// @Override
	// protected Object clone() throws CloneNotSupportedException {
	// return super.clone();
	// }

	public float distancia(Ponto ponto) {

		float distancia = ((getPontoX() - ponto.getPontoX()) + (getPontoY() - ponto.getPontoY()));

		return distancia;
	}

	/*
	 * 1.1 Quantos construtores a sua classe possui? R= Dois
	 * 
	 * 1.2 Qual a superclasse do classe Ponto?
	 * 
	 * R= A classe Object !
	 * 
	 * 1.3 A sua classe possui uma representação como String? Qual?
	 * 
	 * R=
	 * 
	 * 1.4 Sobrescreva o método equals(Object) para definir o que seria igualdade
	 * semântica entre duas instâncias de Ponto.
	 * 
	 * 1.9 Como controlar a quantidade de instâncias da classe Ponto?
	 * 
	 * R= Acrescentado um atributo count no construtor da classe, sendo que o atributo devera ser STATIC;
	 */

}
