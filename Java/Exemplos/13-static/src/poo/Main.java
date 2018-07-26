package poo;

public class Main {

	public static void main(String[] args) {
		Pessoa edu, bruno, lenilson,renan;
		edu = new Pessoa();
		bruno = new Pessoa();
		lenilson = new Pessoa();
		renan = new Pessoa();
		
		System.out.printf("Instancias: %d\n", Pessoa.totalInstancias());
		
		edu.setGenero(Pessoa.MASCULINO);
		
		//Erro de compilacao
		//Pessoa.MASCULINO = 'x';
	}
}
