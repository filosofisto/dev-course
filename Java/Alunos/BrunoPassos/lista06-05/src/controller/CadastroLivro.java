package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Livro;

public class CadastroLivro {

	private List<Livro> livros = new ArrayList<>();
	private Map<String, Livro> mapLivros = new HashMap<>();

	public void inclusão(Livro livro) {
		livros.add(livro);
		mapLivros.put(livro.getISBN(), livro);

	}

	public void exclusao(Livro livro) {
		mapLivros.remove(livro.getISBN(),livro);
		livros.remove(livro);
	}

	public void alteraLivro(Livro livro) {
		

	}



	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

}
