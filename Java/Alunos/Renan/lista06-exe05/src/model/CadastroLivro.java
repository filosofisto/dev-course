package model;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class CadastroLivro {
	Set<Livro> colecao = new HashSet<Livro>();

	public CadastroLivro() {
	}

	public CadastroLivro(Livro... livros) {
		this.adicionarLivro(livros);
	}
	
	//	Inclus�o
	public void adicionarLivro(Livro... livros) {
		for (Livro livro : livros) {
			this.colecao.add(livro);
		}
	}
	
	//	Altera��o
	public void alterarLivro(Livro...livros) {
		for(Livro livro : livros) {
			if(this.colecao.contains(livro)) {
				this.colecao.remove(livro);
				this.colecao.add(livro);
			
			}
		}
	}
	
	//	Obter por ISBN
	public Livro obterLivroPorISBN(String ISBN) {
		Livro achado = null;
		for(Livro livro : this.colecao) {
			if(livro.getISBN().equals(ISBN)) {
				achado = livro;
			}
		}
		return achado;
	}
	
	//	Obter por Autor
	public Livro obterLivroPorAutor(String autor) {
		Livro achado = null;
		for(Livro livro : this.colecao) {
			if(livro.getAutor().equals(autor)) {
				achado = livro;
			}
		}
		return achado;
	}
	
	//	Obter por Titulo
	public Livro obterLivroPorTitulo(String titulo) {
		Livro achado = null;
		for(Livro livro : this.colecao) {
			if(livro.getTitulo().equals(titulo)) {
				achado = livro;
			}
		}
		return achado;
	}
	
	//	Exclusão
	public void removerLivro(String... ISBNs) {
		for (String ISBN : ISBNs) {
			for (Livro livro : this.colecao) {
				if (livro.getISBN().equals( ISBN)) {
					this.colecao.remove(livro);
				}
			}
		}
	}
	
	public int getQuantidadeDeLivros() {
		return this.colecao.size();
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((colecao == null) ? 0 : colecao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CadastroLivro other = (CadastroLivro) obj;
		if (colecao == null) {
			if (other.colecao != null)
				return false;
		} else if (!colecao.equals(other.colecao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String txt = "CadastroLivro [ Colecao de Livros = "  ;
		for(Livro livro : this.colecao) {
			txt += "\n "+livro.toString();
			
		}
		txt += " ]";
		return txt;
	}

}
