package controller;

import java.util.*;

import exception.LivroExistenteException;
import exception.LivroNaoEncontradoException;
import model.Livro;

public class CadastroLivro {

	private Set<Livro> livros = new HashSet<>();
	private Map<String, Livro> mapLivros = new HashMap<>();

	public void incluir(Livro livro) throws LivroExistenteException {
		if (livros.add(livro)) {
			mapLivros.put(livro.getIsbn(), livro);
		} else {
			throw new LivroExistenteException("ISBN: " + livro.getIsbn());
		}
	}

	public void excluir(String isbn) throws LivroNaoEncontradoException {
		Livro livro = mapLivros.get(isbn);
		if (livro == null) {
			throw new LivroNaoEncontradoException("ISBN: " + isbn);
		}
		mapLivros.remove(isbn);
		livros.remove(livro);
	}

	public void alterar(Livro livro) throws LivroNaoEncontradoException {
		Livro livroPersistido = mapLivros.get(livro.getIsbn());
		if (livroPersistido == null) {
			throw new LivroNaoEncontradoException("ISBN: " + livro.getIsbn());
		}

		livroPersistido.setAutor(livro.getAutor());
		livroPersistido.setTitulo(livro.getTitulo());
	}

	public Livro obterPorISBN(String isbn) throws LivroNaoEncontradoException {
		Livro livro = mapLivros.get(isbn);
		if (livro == null) {
			throw new LivroNaoEncontradoException("ISBN: " + isbn);
		}

		return livro;
	}

	public List<Livro> consultarPorTitulo(String titulo) {
		List<Livro> ret = new ArrayList<>();

		for (Livro livro: livros) {
			if (livro.getTitulo().toUpperCase().contains(titulo.toUpperCase())) {
				ret.add(livro);
			}
		}

		Collections.sort(ret);

		return ret;
	}

	public List<Livro> consultarPorAutor(String autor) {
		List<Livro> ret = new ArrayList<>();

		for (Livro livro: livros) {
			if (livro.getAutor().toUpperCase().contains(autor.toUpperCase())) {
				ret.add(livro);
			}
		}

		Collections.sort(ret, new Comparator<Livro>() {
			@Override
			public int compare(Livro o1, Livro o2) {
				return o1.getAutor().toUpperCase().compareTo(o2.getAutor().toUpperCase());
			}
		});

		return ret;
	}

	public Set<Livro> getLivros() {
		return livros;
	}
}
