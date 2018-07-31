package model;

import java.util.Objects;

public class Livro implements Comparable<Livro> {

	private String autor;
	private String titulo;
	private String isbn;

	public Livro(String isbn) {
		setIsbn(isbn);
	}

	public Livro(String autor, String titulo, String isbn) {
		super();
		this.autor = autor;
		this.titulo = titulo;
		this.isbn = isbn;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String iSBN) {
		isbn = iSBN;
	}

	@Override
	public String toString() {
		return "Livro [autor=" + autor + ", titulo=" + titulo + ", isbn=" + isbn + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Livro livro = (Livro) o;
		return Objects.equals(isbn, livro.isbn);
	}

	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}

	@Override
	public int compareTo(Livro o) {
		return getTitulo().compareTo(o.getTitulo());
	}
}
