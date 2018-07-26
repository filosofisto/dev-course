package poo;

public class Main {

	public static void main(String[] args) {
		Circulo c = new Circulo(2);
		System.out.printf(
				"Area do Circulo de raio: %.2f => %.2f\n" +
				"\tPerimetro => %.2f\n" +
				"\tPonto => %s\n", 
				c.getRaio(), 
				c.area(), 
				c.perimetro(),
				c.getPonto()
		);
		
		Retangulo r = new Retangulo(2,3);
		System.out.printf(
				"Area do retangulo com largura %.2f e altura %.2f => %.2f\n" +
				"\tPerimetro => %.2f\n",
				r.getLargura(),
				r.getAltura(),
				r.area(),
				r.perimetro()
		);
		
		Figura figuras[] = new Figura[2];
		figuras[0] = c;
		figuras[1] = r;
		
		for (Figura f: figuras) {
			System.out.printf("Area: %.2f - Perimetro: %.2f\n", f.area(), f.perimetro());
		}
		
		Ponto p = new Ponto();
		p.equals(null);
	}
}
