package lista06;

import java.util.ArrayList;
import java.util.List;

import controller.CadastroLivro;
import model.Livro;

public class Main {

	public static void main(String[] args) {

		Livro livroJoao = new Livro("Joao", "JAVA 8", "12-N-3");
		Livro livroRicardo = new Livro("Ricardo", "Spring Boot", "1221-N-33");
		
		CadastroLivro cadastroLivro = new CadastroLivro();
		
		cadastroLivro.inclusão(livroJoao);
//		cadastroLivro.exclusao(livroJoao);

		
		
		
	}

}
