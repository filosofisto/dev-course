package lista04;

public class Main {

	public static void main(String[] args) {

		Ponto ponto = new Ponto(4,5);
		Ponto ponto2 = new Ponto(3,4);
		Ponto ponto3 = new Ponto(3,4);
		System.out.println(ponto.getCount()); // verifica quantas instancias de pontos existem.
		System.out.println("DISTANCIA: " + ponto.distancia(ponto2));
	}

}
