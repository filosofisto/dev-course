package poo;

public class Pessoa {

	public final static char MASCULINO = 'M';
	public final static char FEMININO = 'F';
	
	private static int count;
	
	static {
		count = 0;
	}
	
	private char genero;
	
	public Pessoa() {
		count++;
	}
	
	public static int totalInstancias() {
		return count;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}
	
	
}
