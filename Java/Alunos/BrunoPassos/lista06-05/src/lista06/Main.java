package lista06;

import controller.CadastroLivro;
import exception.LivroExistenteException;
import exception.LivroNaoEncontradoException;
import model.Livro;
import static java.lang.System.out;

import java.util.List;

public class Main {

	public static void main(String[] args) {

		Livro livroJoao = new Livro("Joao", "JAVA 8", "12-N-3");
		Livro livroRicardo = new Livro("Ricardo", "Spring Boot", "1221-N-33");
		Livro livro3 = new Livro("Francisco de Assis", "Spring for Dummies", "1221-N-44");
		
		CadastroLivro cadastroLivro = new CadastroLivro();

		try {
			cadastroLivro.incluir(livroJoao);
			cadastroLivro.incluir(livroRicardo);
			cadastroLivro.incluir(livro3);

			List<Livro> livros = cadastroLivro.consultarPorTitulo("Spring");
			showLivros(livros);

			//cadastroLivro.excluir("1221-N-44");
			Livro springForDummies = new Livro("1221-N-44");
			springForDummies.setTitulo("SPRING for smarties");
			springForDummies.setAutor("Francisco de Assis");
			cadastroLivro.alterar(springForDummies);

			List<Livro> livroAutores = cadastroLivro.consultarPorAutor("Assis");
			showLivros(livroAutores);
		} catch (LivroExistenteException | LivroNaoEncontradoException e) {
			e.printStackTrace();
		}
	}

	private static void showLivros(List<Livro> livros) {
		out.println();

		for (Livro livro: livros) {
			out.println(livro);
		}
	}
}
